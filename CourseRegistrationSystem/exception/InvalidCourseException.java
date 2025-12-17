package com.crs.exception;

@SuppressWarnings("serial")
public
class InvalidCourseException extends Exception {
    public InvalidCourseException(String message) {
        super(message);
    }
}

