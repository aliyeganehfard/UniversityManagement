package controller.exception;

public class TermException extends RuntimeException{
    public TermException() {
    }

    public TermException(String message) {
        super(message);
    }

    public TermException(String message, Throwable cause) {
        super(message, cause);
    }
}
