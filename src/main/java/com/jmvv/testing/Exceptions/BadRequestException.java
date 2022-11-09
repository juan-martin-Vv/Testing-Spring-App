package com.jmvv.testing.Exceptions;


public class BadRequestException extends RuntimeException{
    public BadRequestException (String msg){
        super(msg);
    }
}
