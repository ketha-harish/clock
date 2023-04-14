package com.speaking.clock.exception;

import com.speaking.clock.model.CommonResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExpectionHandler  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = InvalidInputException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody CommonResponseModel handleExpection(InvalidInputException ex){
        System.out.println(ex.getMessage());
        return new CommonResponseModel("1",ex.getMessage());
    }
}
