package com.springbootacedamyfirst.pointofproject.advisor;

import com.springbootacedamyfirst.pointofproject.exception.NotFoundException;
import com.springbootacedamyfirst.pointofproject.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppWideExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity handleNotFoundException(NotFoundException e){
        return new ResponseEntity(new StandardResponse(404,"Error",e.getMessage()), HttpStatus.NOT_FOUND);
    }

}
