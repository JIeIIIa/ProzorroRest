package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DataItemTest implements DataItemSource {

    private static ObjectMapper objectMapper;

    @BeforeAll
    static void initAll() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.findAndRegisterModules();
        objectMapper.getFactory().configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    }

    @TestFactory
    Stream<DynamicContainer> dynamicTestCollections() {
        return Stream.of(dataItemSourceFirst(), dataItemSourceSecond(), dataItemSourceThird())
                .flatMap(Function.identity())
                .map(this::createTests);
    }

    DynamicContainer createTests(Map.Entry<DataItem, String> pair) {
        return DynamicContainer.dynamicContainer(
                pair.getValue(),
                Stream.of(
                        DynamicTest.dynamicTest("serialize", () -> {
                            //When
                            String result = objectMapper.writeValueAsString(pair.getKey());

                            //Then
                            assertThat(jsonElements(result))
                                    .containsExactlyInAnyOrder(jsonElements(pair.getValue()));
                        }),
                        DynamicTest.dynamicTest("deserialize", ()->{
                            //When
                            DataItem result = objectMapper.readValue(pair.getValue(), DataItem.class);

                            //Then
                            assertThat(result).isEqualTo(pair.getKey());
                        })
                )
        );
    }

    private String[] jsonElements(String json) {
        return json.substring(1, json.length()-2).split("\",\"");
    }
}