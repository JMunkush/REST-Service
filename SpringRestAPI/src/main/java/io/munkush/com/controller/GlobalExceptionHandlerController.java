package io.munkush.com.controller;

import io.munkush.com.exception.EmployeeIncorrectData;
import io.munkush.com.exception.NoSuchEmployeeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class GlobalExceptionHandlerController {

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> exceptionResponse(
            NoSuchEmployeeException exception){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .contentType(MediaType.APPLICATION_JSON)
                .body(EmployeeIncorrectData
                        .builder()
                        .info(exception.getMessage())
                        .dateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss")))
                        .build());

    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> exceptionResponse(
            Exception exception){

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .contentType(MediaType.APPLICATION_JSON)
                .body(EmployeeIncorrectData
                        .builder()
                        .info(exception.getMessage())
                        .dateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:ss")))
                        .build());

    }
}
