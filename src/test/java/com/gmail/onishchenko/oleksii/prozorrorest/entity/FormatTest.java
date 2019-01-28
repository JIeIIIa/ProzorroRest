package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.gmail.onishchenko.oleksii.prozorrorest.entity.Format.*;
import static org.assertj.core.api.Assertions.assertThat;

class FormatTest {

    static Stream<Arguments> valueProvider() {
        return Stream.of(
                Arguments.of("text/plain",TEXT_PLAIN),
                Arguments.of("TEXT/plain",TEXT_PLAIN),
                Arguments.of("application/pkcs7-signature",APPLICATION_PKCS7_SIGNATURE),
                Arguments.of("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet",APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML),
                Arguments.of("application/vnd.openxmlformats-officedocument.wordprocessingml.document",APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_WORDPROCESSINGML),
                Arguments.of("image/jpeg",IMAGE_JPEG),
                Arguments.of("image/png",IMAGE_PNG),
                Arguments.of("illegal/value", UNKNOWN)
        );
    }

    @ParameterizedTest
    @MethodSource(value = {"valueProvider"})
    void fromString(String value, Format expected) {
        //When
        Format result = Format.fromString(value);

        //Then
        assertThat(result).isEqualTo(expected);
    }
}