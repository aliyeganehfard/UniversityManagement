package model.repository.student;

import model.entity.Score;

import java.util.List;

public interface StudentRepository {
    List<Score> getStudentCourse(Integer id);
}
