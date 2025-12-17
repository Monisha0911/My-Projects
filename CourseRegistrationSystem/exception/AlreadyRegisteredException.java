package com.crs.exception;

@SuppressWarnings("serial")
public
class AlreadyRegisteredException extends Exception {
    public AlreadyRegisteredException(String message) {
        super(message);
    }
}

