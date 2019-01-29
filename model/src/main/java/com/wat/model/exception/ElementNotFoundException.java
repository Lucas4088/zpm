package com.wat.model.exception;

import lombok.Data;

public class ElementNotFoundException extends Exception {
    private String message;

    public ElementNotFoundException(String message) {
        super(message);
    }
}
