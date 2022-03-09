package controller.service.college;

import controller.service.ServiceImpl;
import model.entity.College;
import model.repository.college.CollegeRepository;
import model.repository.college.CollegeRepositoryImpl;

public class CollegeServiceImpl extends ServiceImpl<CollegeRepositoryImpl, College, Integer> implements CollegeRepository {
    private CollegeRepositoryImpl collegeRepository;

    public CollegeServiceImpl() {
        super(new CollegeRepositoryImpl());
        collegeRepository = new CollegeRepositoryImpl();
    }
}
