package com.learn.demo.exception;

public class UserNameNotNullException extends RuntimeException{
    public UserNameNotNullException() {
    }
    public UserNameNotNullException(String msg) {
        super(msg);
    }
}
