package io.vventure.xventuremongotask.user.Exception;

public class DeleteWasNotwork extends RuntimeException{
    public DeleteWasNotwork() {
    }

    public DeleteWasNotwork(String message) {
        super(message);
    }

    public DeleteWasNotwork(String message, Throwable cause) {
        super(message, cause);
    }

    public DeleteWasNotwork(Throwable cause) {
        super(cause);
    }

    public DeleteWasNotwork(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
