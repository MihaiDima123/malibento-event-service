package com.malibentoeventservice.malibentoeventservice.exceptions.api;

public class MalibentoNotFoundException extends RuntimeException {
    private static final String ERROR_TEMPLATE = "%s not found";

    public MalibentoNotFoundException(final String entity) {
        super(String.format(ERROR_TEMPLATE, entity));
    }
}
