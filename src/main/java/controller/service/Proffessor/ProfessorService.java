package controller.service.Proffessor;

import controller.service.LoginBaseService;
import model.entity.Professor;
import model.entity.Score;
import model.entity.Student;
import model.repository.professor.ProfessorRepository;

import java.util.List;

public interface ProfessorService extends ProfessorRepository , LoginBaseService<Professor> {
    List<Student> getStudent(Professor professor);
    List<Score> setScoreForStudent(Professor professor);
}
