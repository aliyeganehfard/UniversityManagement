package controller.service.trainingEmployee;

import controller.service.LoginBaseService;
import model.entity.Student;
import model.entity.TrainingEmployee;
import model.repository.trainingEmployee.TrainingEmployeeRepository;

public interface TrainingEmployeeService extends TrainingEmployeeRepository , LoginBaseService<TrainingEmployee> {
}
