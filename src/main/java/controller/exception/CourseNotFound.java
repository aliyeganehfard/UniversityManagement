package controller.exception;

public class CourseNotFound extends RuntimeException{
    public CourseNotFound() {
    }

    public CourseNotFound(String message) {
        super(message);
    }

    public CourseNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
