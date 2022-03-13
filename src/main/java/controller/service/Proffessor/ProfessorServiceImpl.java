package controller.service.Proffessor;

import controller.service.ServiceImpl;
import controller.service.Student.StudentServiceImpl;
import controller.service.score.ScoreServiceImpl;
import model.entity.Professor;
import model.entity.Score;
import model.entity.Student;
import model.repository.professor.ProfessorRepositoryImpl;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProfessorServiceImpl extends ServiceImpl<ProfessorRepositoryImpl, Professor,Integer> implements ProfessorService {
    private ProfessorRepositoryImpl professorRepository;
    private StudentServiceImpl studentService ;
    private ScoreServiceImpl scoreService;

    public ProfessorServiceImpl() {
        super(new ProfessorRepositoryImpl());
        professorRepository = new ProfessorRepositoryImpl();
        studentService = new StudentServiceImpl();
        scoreService = new ScoreServiceImpl();
    }

    @Override
    public List<Score> getProfessorCourse(Integer id) {
        return professorRepository.getProfessorCourse(id);
    }

    @Override
    public Professor login(String username, String password) {
        return professorRepository.login(Professor.class,username,password);
    }

    @Override
    public List<Student> getStudent(Professor professor) {
        return studentService.findAll(Student.class)
                .stream()
                .filter(student -> student.getCollege().getId().equals(professor.getCollege().getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Score> setScoreForStudent(Professor professor) {
//        Predicate<Score> check = score -> score.getProfessor().getId().equals(professor.getId());
        Predicate<Score> checkStudentScore = score -> score.getScore()==null;
        return scoreService.findAll(Score.class)
                .stream()
//                .filter(check)
                .filter(checkStudentScore)
                .collect(Collectors.toList());
    }
}
