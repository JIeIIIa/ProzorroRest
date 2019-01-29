package com.gmail.onishchenko.oleksii.prozorrorest.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfiguration {
    private final ObjectMapper objectMapper;

    @Autowired
    public ApplicationConfiguration(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void postConstruct() {
        objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    }
}
