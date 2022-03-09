package controller.service.Proffessor;

import controller.service.ServiceImpl;
import model.entity.Professor;
import model.entity.Score;
import model.repository.professor.ProfessorRepositoryImpl;

import java.util.List;

public class ProfessorServiceImpl extends ServiceImpl<ProfessorRepositoryImpl, Professor,Integer> implements ProfessorService {
    private ProfessorRepositoryImpl professorRepository;

    public ProfessorServiceImpl() {
        super(new ProfessorRepositoryImpl());
        professorRepository = new ProfessorRepositoryImpl();
    }

    @Override
    public List<Score> getProfessorCourse(Integer id) {
        return professorRepository.getProfessorCourse(id);
    }
}
