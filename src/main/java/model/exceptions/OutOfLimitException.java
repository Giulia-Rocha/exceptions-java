package model.exceptions;

public class OutOfLimitException extends RuntimeException {
    public OutOfLimitException(String message) {
        super(message);
    }
}
