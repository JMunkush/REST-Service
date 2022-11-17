package io.munkush.com.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

import java.util.Map;

@SuperBuilder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    protected String dateTime;
    protected int statusCode;
    protected HttpStatus status;
    protected String message;
    protected Map<String, ?> data;
}
