package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.gmail.onishchenko.oleksii.prozorrorest.entity.DocumentOf.*;
import static org.assertj.core.api.Assertions.assertThat;

class DocumentOfTest {

    static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of("change", CHANGE),
                Arguments.of("ChAnGe", CHANGE),
                Arguments.of("contract", CONTRACT),
                Arguments.of("CONTRACT", CONTRACT),
                Arguments.of("tender", TENDER),
                Arguments.of("illegalValue", UNKNOWN)
        );
    }

    @ParameterizedTest
    @MethodSource(value = {"valueProvider"})
    void fromString(String value, DocumentOf expected) {
        //When
        DocumentOf result = DocumentOf.fromString(value);

        //Then
        assertThat(result).isEqualTo(expected);
    }
}