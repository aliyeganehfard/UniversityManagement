package controller.service.Student;

import controller.service.ServiceImpl;
import controller.service.course.CourseService;
import controller.service.course.CourseServiceImpl;
import controller.service.score.ScoreServiceImpl;
import model.entity.Course;
import model.entity.Score;
import model.entity.Student;
import model.repository.LoginBase;
import model.repository.student.StudentRepositoryImpl;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StudentServiceImpl extends ServiceImpl<StudentRepositoryImpl, Student, Integer> implements StudentService {
    private StudentRepositoryImpl studentRepository;
    private CourseServiceImpl courseService;
    private ScoreServiceImpl scoreService;

    public StudentServiceImpl() {
        super(new StudentRepositoryImpl());
        this.studentRepository = new StudentRepositoryImpl();
        this.courseService = new CourseServiceImpl();
        this.scoreService = new ScoreServiceImpl();
    }

    @Override
    public List<Score> getStudentCourse(Integer id) {
        return studentRepository.getStudentCourse(id);
    }

    @Override
    public Student login(String username, String password) {
        return studentRepository.login(Student.class, username, password);
    }

    @Override
    public void selectUnit(Score score) {
        scoreService.save(score);
    }

    @Override
    public List<Course> studentCourseMustSelect(Student student) {
        var selected = getStudentCourse(student.getId())
                .stream()
                .map(Score::getCourse)
                .collect(Collectors.toList());
        var all = courseService.findAll(Course.class);
        List<Course> list = new ArrayList<>();
        for (Course c : all) {
            if (!selected.contains(c))
                list.add(c);
        }
        return list;
    }

    public Double getAveragePoint(Student student){
        return getStudentCourse(student.getId())
                .stream()
                .mapToDouble(Score::getScore)
                .filter(Objects::nonNull)
                .average().getAsDouble();
    }

    @Override
    public List<Score> getResult(Student student) {
//        System.out.println(student.getUserName());
//        scoreService.findAll(Score.class).forEach(System.out::println);
        List<Score> scoreList = scoreService.findAll(Score.class);
        for (Score s : scoreList) {
            System.out.println("++++ " + s);
            System.out.println("----- "+ s.getStudent().getId() );
            if (s.getStudent().getPassword().equals("ali1"))
                System.out.println(s);
        }
//                .filter(score -> score.getStudent().getPassword().equals("ali1"))
//                .filter(score -> score.getStudent().getUserName().equals(student.getUserName()))
//                .sorted(Comparator.comparing(Score::getTerm))
//                .collect(Collectors.toList());
        return null;
    }
}
