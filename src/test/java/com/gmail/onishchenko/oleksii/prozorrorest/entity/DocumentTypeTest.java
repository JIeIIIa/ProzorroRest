package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.gmail.onishchenko.oleksii.prozorrorest.entity.DocumentType.*;
import static org.assertj.core.api.Assertions.assertThat;

class DocumentTypeTest {

    static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of("contractSigned", CONTRACT_SIGNED),
                Arguments.of("CoNtRaCtSigned", CONTRACT_SIGNED),
                Arguments.of("contractAnnexe", CONTRACT_ANNEXE),
                Arguments.of("CONTRACTAnnexe", CONTRACT_ANNEXE),
                Arguments.of("subContract", SUB_CONTRACT),
                Arguments.of("illegalValue", UNKNOWN)
        );
    }

    @ParameterizedTest
    @MethodSource(value = {"valueProvider"})
    void fromString(String value, DocumentType expected) {
        //When
        DocumentType result = DocumentType.fromString(value);

        //Then
        assertThat(result).isEqualTo(expected);
    }
}