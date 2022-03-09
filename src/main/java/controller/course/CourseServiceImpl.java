package controller.course;

import controller.ServiceImpl;
import controller.college.CollegeService;
import model.entity.College;
import model.repository.college.CollegeRepositoryImpl;

public class CourseServiceImpl extends ServiceImpl<CollegeRepositoryImpl, College, Integer> implements CollegeService{
    private CollegeRepositoryImpl collegeRepository;

    public CourseServiceImpl() {
        super(new CollegeRepositoryImpl());
        collegeRepository = new CollegeRepositoryImpl();
    }
}
