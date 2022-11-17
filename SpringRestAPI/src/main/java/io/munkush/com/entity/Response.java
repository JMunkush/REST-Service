package io.munkush.com.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.Map;

@SuperBuilder
@Data
public class Response {
    protected String dateTime;
    protected int statusCode;
    protected HttpStatus status;
    protected String message;
    protected Map<String, ?> data;
}
