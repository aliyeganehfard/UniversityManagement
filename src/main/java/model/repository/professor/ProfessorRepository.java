package model.repository.professor;

import model.entity.Professor;
import model.entity.Score;
import model.repository.LoginBase;

import java.util.List;

public interface ProfessorRepository extends LoginBase<Professor> {
    List<Score> getProfessorCourse(Integer id);
}
