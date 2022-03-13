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

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
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
    public List<Course> studentCourse(Student student) {
//        List<Course> selectedCourse =
//                scoreService.findAll(Score.class)
//                        .stream()
//                        .filter(score -> score.getStudent().getUserName().equals(student.getUserName()))
//                        .map(Score::getCourse)
//                        .collect(Collectors.toList());
//        List<Course> allCourse =
//                courseService.findAll(Course.class)
//                        .stream()
//                        .filter(course -> course.getCollege().getId().equals(student.getCollege().getId()))
//                        .collect(Collectors.toList());
//        allCourse.removeAll(selectedCourse);
//return allCourse;
        var selected = getStudentCourse(1)
                .stream()
                .map(Score::getCourse)
                .collect(Collectors.toList());
        System.out.println("selected");
        selected.forEach(System.out::println);
        var all = courseService.findAll(Course.class);
        System.out.println("all");
        all.forEach(System.out::println);
        System.out.println("finish");
        List<Course> list = new ArrayList<>();
        for (Course c : all) {
            Predicate<Course> filter1 = course -> !course.getId().equals(c.getId());
            if (!selected.contains(c))
                list.add(c);
        }
        return list;
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
