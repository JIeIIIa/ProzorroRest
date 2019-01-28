package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Format {
    TEXT_PLAIN("text/plain"),
    APPLICATION_PKCS7_SIGNATURE("application/pkcs7-signature"),
    APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML("application/vnd.openxmlformats-officedocument.wordprocessingml.document"),
    IMAGE_JPEG("image/jpeg"),
    IMAGE_PNG("image/png"),
    UNKNOWN("UNKNOWN")
    ;

    @JsonValue
    private final String value;

    Format(String value) {
        this.value = value;
    }

    @JsonCreator
    public static Format fromString(String value) {
        for (Format format : values()) {
            if (format.value.equalsIgnoreCase(value)) {
                return format;
            }
        }

        return UNKNOWN;
    }
}
