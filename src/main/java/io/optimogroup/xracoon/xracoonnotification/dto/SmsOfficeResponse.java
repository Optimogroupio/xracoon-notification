package io.optimogroup.xracoon.xracoonnotification.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SmsOfficeResponse {

    @JsonProperty("Success")
    private Boolean success;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Output")
    private Object output;

    @JsonProperty("ErrorCode")
    private Integer errorCode;

}
