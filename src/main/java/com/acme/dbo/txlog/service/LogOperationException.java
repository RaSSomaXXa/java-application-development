package com.acme.dbo.txlog.service;

public class LogOperationException extends Exception{

    public LogOperationException(String message) {
        super(message);
    }

    public LogOperationException(String message, Throwable cause) {
        super(message, cause);
    }

}
