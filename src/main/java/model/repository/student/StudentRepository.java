package model.repository.student;

import model.entity.Score;
import model.entity.Student;
import model.repository.LoginBase;

import java.util.List;

public interface StudentRepository extends LoginBase<Student> {
    List<Score> getStudentCourse(Integer id);
}
