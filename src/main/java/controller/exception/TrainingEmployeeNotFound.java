package controller.exception;

public class TrainingEmployeeNotFound extends RuntimeException{
    public TrainingEmployeeNotFound() {
    }

    public TrainingEmployeeNotFound(String message) {
        super(message);
    }

    public TrainingEmployeeNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
