package io.optimogroup.xracoon.xracoonnotification.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Shako Davitashvili
 * @version 1.0.0.1
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NotificationExceptionResponse {
    private String message;
    private Long errorCode;
}
