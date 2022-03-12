package controller.exception;

public class ScoreNotFound extends RuntimeException{
    public ScoreNotFound() {
    }

    public ScoreNotFound(String message) {
        super(message);
    }

    public ScoreNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
