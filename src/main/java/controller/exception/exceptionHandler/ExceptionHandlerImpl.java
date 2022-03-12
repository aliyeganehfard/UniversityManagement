package controller.exception.exceptionHandler;

import controller.exception.*;

import java.util.stream.DoubleStream;

public class ExceptionHandlerImpl implements ExceptionHandler {
    @Override
    public void isId(Integer id) {
        if (!isDigit(id))
            throw new IdException();
    }

    @Override
    public void isScore(Double score) {
        if (!isDigit(score))
            throw new ScoreException();

        DoubleStream.of(score)
                .forEach(value -> {
                    if (value < 20 || value > 0)
                        throw new ScoreException();
                });
    }

    @Override
    public void isTerm(Integer term) {
        if (!isDigit(term))
            throw new TermException();
    }

    @Override
    public void isUnit(Integer unit) {
        if (!isDigit(unit))
            throw new UnitException();
    }

    @Override
    public <T extends Number> boolean isDigit(T id) {
        for (var chr : id.toString().toCharArray()) {
            if (!Character.isDigit(chr))
                return false;
        }
        return true;
    }
}
