package controller.service.trainingEmployee;

import controller.service.ServiceImpl;
import model.entity.TrainingEmployee;
import model.repository.trainingEmployee.TrainingEmployeeRepositoryImpl;

public class TrainingEmployeeServiceImpl extends ServiceImpl<TrainingEmployeeRepositoryImpl, TrainingEmployee, Integer> implements TrainingEmployeeService {
    private TrainingEmployeeRepositoryImpl trainingEmployeeRepository;

    public TrainingEmployeeServiceImpl() {
        super(new TrainingEmployeeRepositoryImpl());
        trainingEmployeeRepository = new TrainingEmployeeRepositoryImpl();
    }
}
