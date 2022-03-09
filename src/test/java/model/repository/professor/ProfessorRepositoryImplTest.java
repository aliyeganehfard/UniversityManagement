package model.repository.professor;

import model.entity.College;
import model.entity.Professor;
import model.repository.college.CollegeRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProfessorRepositoryImplTest {

    private ProfessorRepositoryImpl professorRepository;
    private CollegeRepositoryImpl collegeRepository;

    @BeforeEach
    public void beforeEach() {
        professorRepository = new ProfessorRepositoryImpl();
        collegeRepository = new CollegeRepositoryImpl();
    }

    @Test
    void save() {
//        arrange
        var college = new College(null, "azad", "lar");
        var professor = new Professor(null,"ali","b", "a", college);
//        act
        collegeRepository.save(college);
        professorRepository.save(professor);
        var load = professorRepository.findById(Professor.class, professor.getId());
//        assert
        assertAll(
                () -> Assertions.assertThat(load).isNotNull(),
                () -> Assertions.assertThat(professor.getId()).isEqualTo(load.getId())
        );
    }

    @Test
    void update(){
//        arrange
        var college = new College(null, "azad", "lar");
        var professor = new Professor(null,"ali","b", "a", college);
//        act
        collegeRepository.save(college);
        professorRepository.save(professor);
        professorRepository.update(new Professor(professor.getId(),"majid","d","a",college));
        var load = professorRepository.findById(Professor.class,professor.getId());
//        assert
        assertAll(
                ()-> Assertions.assertThat("majid").isEqualTo(load.getName()) ,
                ()-> Assertions.assertThat("d").isEqualTo(load.getDegree())
        );
    }

    @Test
    void delete(){
//        arrange
        var college = new College(null, "azad", "lar");
        var professor = new Professor(null,"ali","b", "a", college);
//        act
        collegeRepository.save(college);
        professorRepository.save(professor);
        professorRepository.delete(professor);
        var load = professorRepository.findById(Professor.class,professor.getId());
//        assert
        Assertions.assertThatObject(load).isNull();
    }

    @Test
    void findById(){
//        arrange
        var college = new College(null, "azad", "lar");
        var professor = new Professor(null,"ali","b", "a", college);
//        act
        collegeRepository.save(college);
        professorRepository.save(professor);
        var load = professorRepository.findById(Professor.class, professor.getId());
//        assert
        Assertions.assertThat(load).isNotNull();
    }

    @Test
    void findAll(){
//        arrange
        var college = new College(null, "azad", "lar");
        var professor = new Professor(null,"ali","b", "a", college);
//        act
        var size = professorRepository.findAll(Professor.class);
        collegeRepository.save(college);
        professorRepository.save(professor);
        size.add(professor);
//        assert
        Assertions.assertThat(size)
                .hasSize(professorRepository.findAll(Professor.class).size());
    }
}