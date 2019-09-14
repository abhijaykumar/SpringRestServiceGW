package com.centric.weather;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ZipNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ZipNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    Exception employeeNotFoundHandler(ZipNotFoundException ex) {
        return ex;
    }
}
