package model.repository.professor;

import model.entity.Score;

import java.util.List;

public interface ProfessorRepository {
    List<Score> getProfessorCourse(Integer id);
}
