package model.repository.student;


import controller.service.Student.StudentServiceImpl;
import model.entity.*;
import model.repository.college.CollegeRepositoryImpl;
import model.repository.course.CourseRepositoryImpl;
import model.repository.professor.ProfessorRepositoryImpl;
import model.repository.score.ScoreRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions.*;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertAll;

class StudentRepositoryImplTest {
    private StudentRepositoryImpl studentRepository;
    private CollegeRepositoryImpl collegeRepository;

    @BeforeEach
    public void beforeEach() {
        studentRepository = new StudentRepositoryImpl();
        collegeRepository = new CollegeRepositoryImpl();
    }

    @Test
    void save() {
//        arrange
        var college = new College(null, "azad", "lar");
        var student = new Student(null,"ali","44", "a", "b", college);
//        act
        collegeRepository.save(college);
        studentRepository.save(student);
        var load = studentRepository.findById(Student.class, student.getId());
//        assert
        assertAll(
                () -> Assertions.assertThat(load).isNotNull(),
                () -> Assertions.assertThat(student.getId()).isEqualTo(load.getId())
        );
    }

    @Test
    void update() {
//        arrange
        var college = new College(null, "azad", "lar");
        var student = new Student(null,"ali","4474", "a", "b", college);
//        act
        collegeRepository.save(college);
        studentRepository.save(student);
        studentRepository.update(new Student(student.getId(), "ali","5d","ddd", "lar", college));
        var load = studentRepository.findById(Student.class, student.getId());
//        assert
        assertAll(
                () -> Assertions.assertThat("ali").isEqualTo(load.getName())
        );
    }

    @Test
    void delete() {
//        arrange
        var college = new College(null, "azad", "lar");
        var student = new Student(null,"ali","448", "a", "b", college);
//        act
        collegeRepository.save(college);
        studentRepository.save(student);
        studentRepository.delete(student);
        var load = studentRepository.findById(Student.class, student.getId());
//        assert
        Assertions.assertThat(load).isNull();
    }

    @Test
    void findById() {
//        arrange
        var college = new College(null, "azad", "lar");
        var student = new Student(null,"ali","444", "a", "b", college);
//        act
        collegeRepository.save(college);
        studentRepository.save(student);
        var load = studentRepository.findById(Student.class,student.getId());
//        assert
        Assertions.assertThatObject(load).isNotNull();
    }

    @Test
    void findAll(){
//        arrange
        var college = new College(null, "azad", "lar");
        var student = new Student(null,"ali","4478", "a", "b", college);
//        act
        var size = studentRepository.findAll(Student.class);
        collegeRepository.save(college);
        studentRepository.save(student);
        size.add(student);
//        assert
        Assertions.assertThat(size).hasSize(studentRepository.findAll(Student.class).size());
    }

    @Test
    void login(){
//        arrange
        var college = new College(null, "azad", "lar");
        var student = new Student(null,"ali","1111", "a", "b", college);
//        act
        collegeRepository.save(college);
        studentRepository.save(student);
        var login = studentRepository.login(Student.class,student.getUserName(),student.getPassword());
//        assert
        assertAll(
                ()-> Assertions.assertThat(login).isNotNull(),
                ()-> Assertions.assertThat(login.getUserName()).isEqualTo(student.getUserName()),
                ()-> Assertions.assertThat(login.getPassword()).isEqualTo(student.getPassword())
        );
    }

    @Test
    void getStudentCourse(){
//        arrange
        var sec = new ScoreRepositoryImpl();
        var college = new College(null, "azad","lar");
        var student = new Student(null,"ali","44", "a", "b", college);
        var score = new Score(null,student,
                null,null,1,15.0);
//        act
        collegeRepository.save(college);
        studentRepository.save(student);
        sec.save(score);
        var load = studentRepository.getStudentCourse(student.getId());

//        assert
        Assertions.assertThat(load).hasSize(1);
    }


}