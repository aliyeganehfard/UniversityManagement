package model.repository.student;


import model.entity.College;
import model.entity.Professor;
import model.entity.Student;
import model.repository.college.CollegeRepositoryImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions.*;
import org.assertj.core.api.Assertions.*;

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
        var student = new Student(null, "a", "b", college);
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
        var student = new Student(null, "a", "b", college);
//        act
        collegeRepository.save(college);
        studentRepository.save(student);
        studentRepository.update(new Student(student.getId(), "ali", "lar", college));
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
        var student = new Student(null, "a", "b", college);
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
        var student = new Student(null, "a", "b", college);
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
        var student = new Student(null, "a", "b", college);
//        act
        var size = studentRepository.findAll(Student.class);
        collegeRepository.save(college);
        studentRepository.save(student);
        size.add(student);
//        assert
        Assertions.assertThat(size).hasSize(studentRepository.findAll(Student.class).size());
    }
}