package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EndpointDataBuilderTest {
    static LongStream longs() {
        return ThreadLocalRandom.current().longs(5, 1, Long.MAX_VALUE);
    }

    static Stream<String> strings() {
        return Stream.of(
                "http://url.com",
                "second"
        );
    }

    static Stream<String> illegalEndpoints() {
        return Stream.of(null, "");
    }

    @ParameterizedTest
    @MethodSource(value = {"longs"})
    void id(Long id) {
        //Given
        EndpointData expected = new EndpointData();
        expected.setEndpoint("mock");

        //When
        EndpointData endpointData = EndpointDataBuilder.getInstance().id(id).endpoint("mock").build();

        //Then
        assertThat(endpointData.getId()).isEqualTo(id);
        assertThat(endpointData).isEqualToIgnoringGivenFields(expected, "id");
    }

    @ParameterizedTest
    @MethodSource(value = {"strings"})
    void endpoint(String endpoint) {
        //When
        EndpointData endpointData = EndpointDataBuilder.getInstance().endpoint(endpoint).build();

        //Then
        assertThat(endpointData.getEndpoint()).isEqualTo(endpoint);
        assertThat(endpointData).isEqualToIgnoringGivenFields(new EndpointData(), "endpoint");
    }

    @ParameterizedTest
    @MethodSource(value = {"illegalEndpoints"})
    void endpointIsNull(String endpoint) {
        //When
        assertThrows(IllegalStateException.class, () -> EndpointDataBuilder.getInstance().endpoint(endpoint).build());
    }

    @Test
    void data() {
        //Given
        final DataItem dataItem = new DataItem();
        List<DataItem> list = Collections.singletonList(dataItem);
        EndpointData expected = new EndpointData();
        expected.setEndpoint("mock");
        expected.setData(list);


        //When
        EndpointData endpointData = EndpointDataBuilder.getInstance().data(list).endpoint("mock").build();

        //Then
        assertThat(endpointData.getData()).containsExactlyInAnyOrder(dataItem);
        assertThat(endpointData).isEqualToIgnoringGivenFields(expected, "data");
    }
}