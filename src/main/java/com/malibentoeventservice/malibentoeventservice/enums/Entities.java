package com.malibentoeventservice.malibentoeventservice.enums;

public enum Entities {
    EVENT("event"),
    CLIENT("client");

    private final String value;

    Entities(final String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
