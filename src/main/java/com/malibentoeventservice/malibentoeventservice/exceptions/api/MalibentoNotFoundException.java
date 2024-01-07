package com.malibentoeventservice.malibentoeventservice.exceptions.api;

public class MalibentoNotFoundException extends Exception {
    private static final String ERROR_TEMPLATE = "%s not found";

    public MalibentoNotFoundException(final String entity) {
        super(String.format(ERROR_TEMPLATE, entity));
    }
}
