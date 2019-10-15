package com.stackroute.Movie.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler{

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<?> handlingalreadyexistmovie()
    {
        ResponseEntity responseEntity;
        responseEntity=new ResponseEntity<String>("Movie already present in db", HttpStatus.OK);
        return responseEntity;
    }
}
