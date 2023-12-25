package com.malibentoeventservice.malibentoeventservice.exceptions;

public class NoSuchClientException extends RuntimeException {
    public static final String ERROR_MESSAGE = "No such client";
    public NoSuchClientException() {
        super(ERROR_MESSAGE);
    }
}
