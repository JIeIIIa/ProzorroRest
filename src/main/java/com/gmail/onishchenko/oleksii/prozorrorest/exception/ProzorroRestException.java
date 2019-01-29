package com.gmail.onishchenko.oleksii.prozorrorest.exception;

public class ProzorroRestException extends RuntimeException {

    private static final long serialVersionUID = 1717786585228505L;

    public ProzorroRestException() {
    }

    public ProzorroRestException(String message) {
        super(message);
    }
}
