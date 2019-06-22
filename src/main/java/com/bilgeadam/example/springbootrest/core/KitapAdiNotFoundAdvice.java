package com.bilgeadam.example.springbootrest.core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class KitapAdiNotFoundAdvice {


    @ResponseBody
    @ExceptionHandler(KitapAdiNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String kitapAdiNotFoundHandler(KitapAdiNotFoundException ex){
        ex.printStackTrace();
        return ex.getMessage();
    }

    @ResponseBody
    @ExceptionHandler(BaslikNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String baslikNotFoundException(BaslikNotFoundException ex){
        ex.printStackTrace();
        return ex.getMessage();
    }
}
