package com.malibentoeventservice.malibentoeventservice.enums;

import lombok.Getter;

@Getter
public enum Entities {
    EVENT("event"),
    CLIENT("client");

    private final String value;

    Entities(final String value) {
        this.value = value;
    }
}
