package controller.exception.exceptionHandler;

public interface ExceptionHandler {
    void isId(Integer id);
    void isScore(Double score);
    void isTerm(Integer term);
    void isUnit(Integer unit);
    <T extends Number> boolean isDigit(T id);
}
