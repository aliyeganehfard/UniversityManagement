package model.repository.score;

import model.entity.*;
import model.repository.college.CollegeRepositoryImpl;
import model.repository.course.CourseRepository;
import model.repository.course.CourseRepositoryImpl;
import model.repository.professor.ProfessorRepositoryImpl;
import model.repository.student.StudentRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreRepositoryImplTest {
    private ProfessorRepositoryImpl professorRepository ;
    private StudentRepositoryImpl studentRepository ;
    private CourseRepositoryImpl courseRepository ;
    private CollegeRepositoryImpl collegeRepository ;
    private ScoreRepositoryImpl scoreRepository;

    private College college;
    private Professor professor;
    private Student student;
    private Course course;

    @BeforeEach
    public void beforeEach(){
        professorRepository = new ProfessorRepositoryImpl();
        studentRepository = new StudentRepositoryImpl();
        courseRepository = new CourseRepositoryImpl();
        collegeRepository = new CollegeRepositoryImpl();
        scoreRepository = new ScoreRepositoryImpl();

        var college = new College(null, "azad","lar");
        var professor = new Professor(null,"ali","b", "a", college);
        var student = new Student(null, "a", "b", college);
        var course = new Course(null,"java",2,college);
        collegeRepository.save(college);
        professorRepository.save(professor);
        courseRepository.save(course);
        studentRepository.save(student);
    }

    @Test
    void save(){
//        arrange
        var score = new Score(null,student,professor,course,1,15.0);
//        act
        scoreRepository.save(score);
        var load = scoreRepository.findById(Score.class,score.getId());
//        assert
        Assertions.assertThat(load).isNotNull();
    }

    @Test
    void update(){
//        arrange
        var score = new Score(null,student,professor,course,1,15.0);
//        act
        scoreRepository.save(score);
        scoreRepository.update(new Score(score.getId(), student,professor,course,2,20.0));
        var load = scoreRepository.findById(Score.class ,score.getId());
//        assert
        assertAll(
                ()-> Assertions.assertThat(2).isEqualTo(load.getTerm()),
                ()-> Assertions.assertThat(20.0).isEqualTo(load.getScore())
        );
    }

    @Test
    void delete(){
//        arrange
        var score = new Score(null,student,professor,course,1,15.0);
//        act
        scoreRepository.save(score);
        scoreRepository.delete(score);
        var load = scoreRepository.findById(Score.class,score.getId());
//        assert
        Assertions.assertThat(load).isNull();
    }

    @Test
    void findById(){
//        arrange
        var score = new Score(null,student,professor,course,1,15.0);
//        act
        scoreRepository.save(score);
        var load = scoreRepository.findById(Score.class,score.getId());
//        assert
        Assertions.assertThat(load).isNotNull();
    }

    @Test
    void findAll(){
//        arrange
        var score = new Score(null,student,professor,course,1,15.0);
//        act
        var size = scoreRepository.findAll(Score.class);
        scoreRepository.save(score);
        size.add(score);
//        assert
        Assertions.assertThat(size).hasSize(scoreRepository.findAll(Score.class).size());
    }
}