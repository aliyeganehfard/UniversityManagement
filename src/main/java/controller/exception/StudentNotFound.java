package controller.exception;

public class StudentNotFound extends RuntimeException{
    public StudentNotFound() {
    }

    public StudentNotFound(String message) {
        super(message);
    }

    public StudentNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
