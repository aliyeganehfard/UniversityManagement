package controller.exception;

public class ProfessorNotFound extends RuntimeException{
    public ProfessorNotFound() {
    }

    public ProfessorNotFound(String message) {
        super(message);
    }

    public ProfessorNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
