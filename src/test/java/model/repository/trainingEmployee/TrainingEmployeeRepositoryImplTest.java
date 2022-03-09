package model.repository.trainingEmployee;

import model.entity.College;
import model.entity.TrainingEmployee;
import model.repository.college.CollegeRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TrainingEmployeeRepositoryImplTest {

    private TrainingEmployeeRepositoryImpl trainingEmployeeRepository;
    private CollegeRepositoryImpl collegeRepository ;
    @BeforeEach
    public void beforeEach(){
        trainingEmployeeRepository = new TrainingEmployeeRepositoryImpl();
        collegeRepository = new CollegeRepositoryImpl();
    }

    @Test
    void save(){
//        arrange
        var college = new College(null,"azada","lar");
        var trainingEmployee = new TrainingEmployee(null,"ali","142643","123",college);
//        act
        collegeRepository.save(college);
        trainingEmployeeRepository.save(trainingEmployee);
        var load = trainingEmployeeRepository.findById(TrainingEmployee.class,trainingEmployee.getId());
//        assert
        assertAll(
                ()->Assertions
                        .assertThat(load)
                        .isNotNull(),
                ()->Assertions
                        .assertThat(load.getId())
                        .isEqualTo(trainingEmployee.getId())
        );
    }

    @Test
    void update(){
//        arrange
        var college = new College(null,"azad","lar");
        var trainingEmployee = new TrainingEmployee(null,"ali","12","123",college);
//        act
        collegeRepository.save(college);
        trainingEmployeeRepository.save(trainingEmployee);
        trainingEmployeeRepository.update(new TrainingEmployee(trainingEmployee.getId(),"majid","123","123",college));
//        assert
        var load = trainingEmployeeRepository.findById(TrainingEmployee.class,trainingEmployee.getId());
        assertAll(
                ()-> Assertions.assertThat(trainingEmployee.getId()).isEqualTo(load.getId()),
                ()-> Assertions.assertThat("majid").isEqualTo(load.getName())
        );
    }

    @Test
    void delete(){
//        arrange
        var college = new College(null,"azad","lar");
        var trainingEmployee = new TrainingEmployee(null,"ali","13","123",college);
//        act
        collegeRepository.save(college);
        trainingEmployeeRepository.save(trainingEmployee);
        trainingEmployeeRepository.delete(trainingEmployee);
        var load =trainingEmployeeRepository.findById(TrainingEmployee.class,trainingEmployee.getId()) ;
//        assert
        Assertions.assertThatObject(load).isNull();

    }

    @Test
    void deleteById(){

    }

    @Test
    void findById(){
//        arrange
        var college = new College(null,"azad","lar");
        var trainingEmployee = new TrainingEmployee(null,"ali","23","123",college);
//        act
        collegeRepository.save(college);
        trainingEmployeeRepository.save(trainingEmployee);
        var load = trainingEmployeeRepository.findById(TrainingEmployee.class,trainingEmployee.getId());
//        assert
        Assertions
                .assertThatObject(load).isNotNull();
    }

    @Test
    void findAll(){
//        arrange
        var college = new College(null,"azad","lar");
        var trainingEmployee = new TrainingEmployee(null,"ali","1423","123",college);
//        act
        var size = trainingEmployeeRepository.findAll(TrainingEmployee.class);
        collegeRepository.save(college);
        trainingEmployeeRepository.save(trainingEmployee);
        size.add(trainingEmployee);
//        assert
        Assertions
                .assertThat(size)
                .hasSize(trainingEmployeeRepository.findAll(TrainingEmployee.class).size());
    }

    @Test
    void login(){
//        arrange
        var college = new College(null,"azad","lar");
        var trainingEmployee = new TrainingEmployee(null,"ali","1423","123",college);
//        act
        collegeRepository.save(college);
        trainingEmployeeRepository.save(trainingEmployee);
        var login = trainingEmployeeRepository.login(TrainingEmployee.class,trainingEmployee.getUserName(),trainingEmployee.getPassword());
//        var login = trainingEmployeeRepository.login("1423","123");
//        assert
        assertAll(
                ()-> Assertions.assertThat(login).isNotNull(),
                ()-> Assertions.assertThat(login.getUserName()).isEqualTo(trainingEmployee.getUserName()),
                ()-> Assertions.assertThat(login.getPassword()).isEqualTo(trainingEmployee.getPassword())
        );
    }
}