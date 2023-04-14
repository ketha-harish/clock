package com.speaking.clock.exception;

public class InvalidInputException extends RuntimeException{

    private String message;

    public InvalidInputException(String msg){
        super(msg);
        this.message=msg;
    }
}
