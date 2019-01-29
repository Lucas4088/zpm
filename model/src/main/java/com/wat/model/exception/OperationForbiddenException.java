package com.wat.model.exception;

public class OperationForbiddenException  extends Exception {
    private String message;

    public OperationForbiddenException(String message) {
        super(message);
    }
}
