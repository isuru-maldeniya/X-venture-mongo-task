package io.vventure.xventuremongotask.user.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(value = {NoUserAvailableException.class})
    public ResponseEntity<Object> handleNoUser(NoUserAvailableException e){
        return new ResponseEntity<>(new ExceptionModel(e.getMessage(),e, HttpStatus.BAD_REQUEST, ZonedDateTime.now()) ,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = {DeleteWasNotwork.class})
    public ResponseEntity<Object> DeleteNotWork(DeleteWasNotwork e){
        return new ResponseEntity<>(new ExceptionModel(e.getMessage(), e,HttpStatus.EXPECTATION_FAILED,ZonedDateTime.now()),HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(value = {GnaricException.class})
    public ResponseEntity<Object> handleGenericException(GnaricException e){
        return new ResponseEntity<>(new ExceptionModel(e.getMessage(),e.getCause(),e.getHttpStatus(),ZonedDateTime.now()),e.getHttpStatus());
    }
}
