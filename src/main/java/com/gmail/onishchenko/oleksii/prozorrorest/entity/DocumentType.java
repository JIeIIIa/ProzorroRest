package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum DocumentType {
    CONTRACT_SIGNED("contractSigned"),
    CONTRACT_ANNEXE("contractAnnexe"),
    SUB_CONTRACT("subContract"),
    UNKNOWN("UNKNOWN");

    @JsonValue
    private String value;

    DocumentType(String value) {
        this.value = value;
    }

    @JsonCreator
    public static DocumentType fromString(String value) {
        for (DocumentType documentType : values()) {
            if (documentType.value.equalsIgnoreCase(value)) {
                return documentType;
            }
        }

        return UNKNOWN;
    }
}
