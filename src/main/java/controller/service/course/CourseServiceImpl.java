package controller.service.course;

import controller.service.ServiceImpl;
import controller.service.college.CollegeService;
import model.entity.College;
import model.entity.Course;
import model.repository.college.CollegeRepositoryImpl;
import model.repository.course.CourseRepositoryImpl;

public class CourseServiceImpl extends ServiceImpl<CourseRepositoryImpl, Course, Integer> implements CourseService{
    private CourseRepositoryImpl courseRepository;

    public CourseServiceImpl() {
        super(new CourseRepositoryImpl());
        courseRepository = new CourseRepositoryImpl();
    }
}
