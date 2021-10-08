package io.vventure.xventuremongotask.user.Exception;

public class NoUserAvailableException extends RuntimeException{

    public NoUserAvailableException() {
    }

    public NoUserAvailableException(String message) {
        super(message);
    }

    public NoUserAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoUserAvailableException(Throwable cause) {
        super(cause);
    }

    public NoUserAvailableException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
