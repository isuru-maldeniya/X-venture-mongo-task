package io.vventure.xventuremongotask.user.Exception;

import org.springframework.http.HttpStatus;

public class GnaricException extends RuntimeException{
    private final HttpStatus httpStatus;

    public GnaricException(StatusEnum statusEnum,Throwable cause) {
        super(statusEnum.getMessage(),cause);
        this.httpStatus = statusEnum.getHttpStatus();
    }

    public GnaricException(String message, StatusEnum statusEnum) {
        super(message);
        this.httpStatus = statusEnum.getHttpStatus();
    }

    public GnaricException(String message, Throwable cause, HttpStatus httpStatus) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }

    public GnaricException(Throwable cause, HttpStatus httpStatus) {
        super(cause);
        this.httpStatus = httpStatus;
    }

    public GnaricException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, HttpStatus httpStatus) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
