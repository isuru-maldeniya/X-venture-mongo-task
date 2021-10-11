package io.vventure.xventuremongotask.user.Exception;

import org.springframework.http.HttpStatus;

public enum StatusEnum {
    USER_NOT_AVAILABLE("User is not available",HttpStatus.BAD_REQUEST),
    USER_LIST_EMPTY("User List is empty",HttpStatus.BAD_REQUEST);

    private String message;
    private HttpStatus httpStatus;

    StatusEnum(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
