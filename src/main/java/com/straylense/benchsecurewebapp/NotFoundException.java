package com.straylense.benchsecurewebapp;

public class NotFoundException extends Exception {

    private static final String DEFAULT_MESSAGE = "Not Found";

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String messsage, Throwable throwable) {
        super(messsage, throwable);
    }

    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }
}
