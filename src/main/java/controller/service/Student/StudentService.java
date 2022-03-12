package controller.service.Student;

import controller.service.LoginBaseService;
import model.entity.Course;
import model.entity.Score;
import model.entity.Student;
import model.repository.LoginBase;
import model.repository.student.StudentRepository;

import java.util.List;

public interface StudentService extends StudentRepository , LoginBaseService<Student> {
    void selectUnit(Score score);
    List<Course> studentCourse(Student student);
    List<Score> getResult(Student student);
}
