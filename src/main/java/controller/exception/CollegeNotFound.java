package controller.exception;

public class CollegeNotFound extends RuntimeException{
    public CollegeNotFound() {
    }

    public CollegeNotFound(String message) {
        super(message);
    }

    public CollegeNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
