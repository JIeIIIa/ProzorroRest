package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Language {
    UK("uk"),
    UNKNOWN("UNKNOWN");

    @JsonValue
    private String value;

    Language(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Language fromString(String value) {
        for (Language language : values()) {
            if (language.value.equalsIgnoreCase(value)) {
                return language;
            }
        }

        return UNKNOWN;
    }
}
