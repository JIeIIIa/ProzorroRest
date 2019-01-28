package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentOf {
    CHANGE("change"),
    CONTRACT("contract"),
    TENDER("tender"),
    UNKNOWN("UNKNOWN");

    @JsonValue
    private String value;

    DocumentOf(String value) {
        this.value = value;
    }

    @JsonCreator
    public static DocumentOf fromString(String value) {
        for (DocumentOf documentOf : values()) {
            if (documentOf.value.equalsIgnoreCase(value)) {
                return documentOf;
            }
        }

        return UNKNOWN;
    }
}
