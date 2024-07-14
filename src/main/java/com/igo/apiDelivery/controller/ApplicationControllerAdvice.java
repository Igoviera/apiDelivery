package com.igo.apiDelivery.controller;

import com.igo.apiDelivery.exception.BagEmptyException;
import com.igo.apiDelivery.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApplicationControllerAdvice {
    @ExceptionHandler(RecordNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErros handleNotFoundExecption(RecordNotFoundException ex){
        return new ApiErros(ex.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleMethodNotValidExecption(MethodArgumentNotValidException ex){
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(erro -> erro.getDefaultMessage())
                .collect(Collectors.toList());
        return new ApiErros(errors);
    }
    @ExceptionHandler(BagEmptyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleBagEmptyException(BagEmptyException ex){
        return new ApiErros(ex.getMessage());
    }
}
