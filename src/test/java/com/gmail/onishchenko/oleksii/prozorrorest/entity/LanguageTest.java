package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.gmail.onishchenko.oleksii.prozorrorest.entity.Language.UK;
import static com.gmail.onishchenko.oleksii.prozorrorest.entity.Language.UNKNOWN;
import static org.assertj.core.api.Assertions.assertThat;

class LanguageTest {

    static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of("uk", UK),
                Arguments.of("Uk", UK),
                Arguments.of("illegalValue", UNKNOWN)
        );
    }

    @ParameterizedTest
    @MethodSource(value = {"valueProvider"})
    void fromString(String value, Language expected) {
        //When
        Language result = Language.fromString(value);

        //Then
        assertThat(result).isEqualTo(expected);
    }
}