package com.stackroute.exception;

public class UserAlreadyExistException extends Exception {
    private String message;
    public UserAlreadyExistException(){}
    public UserAlreadyExistException(String message){
        super(message);
        this.message=message;
    }
}
