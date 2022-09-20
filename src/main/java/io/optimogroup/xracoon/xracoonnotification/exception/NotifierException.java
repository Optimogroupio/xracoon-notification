package io.optimogroup.xracoon.xracoonnotification.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotifierException extends RuntimeException {

    private String massage;
    private HttpStatus httpStatus;

    public NotifierException(String s) {
        this.massage = s;
    }
}
