package controller.service.Student;

import controller.service.ServiceImpl;
import model.entity.Score;
import model.entity.Student;
import model.repository.student.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl extends ServiceImpl<StudentRepositoryImpl, Student, Integer> implements StudentService {
    private StudentRepositoryImpl studentRepository;

    public StudentServiceImpl() {
        super(new StudentRepositoryImpl());
        this.studentRepository = new StudentRepositoryImpl();
    }

    @Override
    public List<Score> getStudentCourse(Integer id) {
        return studentRepository.getStudentCourse(id);
    }
}
