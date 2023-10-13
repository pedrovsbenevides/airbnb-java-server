package com.airbnbserver.exceptions;

public class BusinessException extends RuntimeException {
    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Object... args) {
        super(String.format(message, args));
    }
}
