package com.gmail.onishchenko.oleksii.prozorrorest.configuration;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class ApplicationConfiguration {

    private static final Logger LOG = LogManager.getLogger(ApplicationConfiguration.class);

    private final ObjectMapper objectMapper;

    @Autowired
    public ApplicationConfiguration(ObjectMapper objectMapper) {
        LOG.debug("Create instance of {}", ApplicationConfiguration.class.getName());
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void postConstruct() {
        LOG.debug("Configure objectMapper");
        objectMapper.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, true);
    }
}
