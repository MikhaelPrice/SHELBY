package com.SHELBY.calculator.exceptions;

public class calcException extends Exception {
    public calcException() {
    }

    public calcException(String message) {
        super("ERROR: " + message);
    }

    public calcException(String message, Throwable cause) {
        super("ERROR: " + message, cause);
    }

    public calcException(Throwable cause) {
        super(cause);
    }

    public calcException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super("ERROR: " + message, cause, enableSuppression, writableStackTrace);
    }
}
