package io.optimogroup.xracoon.xracoonnotification.exception;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */

@RestControllerAdvice
@Slf4j
public class ExceptionHelper {
    @ExceptionHandler(value = {NotifierException.class})
    public ResponseEntity<NotificationExceptionResponse> handleBusinessException(NotifierException ex) {
        log.error("NotifierException Exception: ", ex);
        return new ResponseEntity<>(NotificationExceptionResponse.builder().message(ex.getMessage()).build(),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
