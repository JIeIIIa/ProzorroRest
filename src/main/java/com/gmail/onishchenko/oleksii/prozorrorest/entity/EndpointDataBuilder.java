package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import java.util.List;

import static java.util.Objects.isNull;

public class EndpointDataBuilder {
    private Long id;

    private String endpoint;

    private List<DataItem> data;

    private EndpointDataBuilder() {
        
    }

    public static EndpointDataBuilder getInstance() {
        return new EndpointDataBuilder();
    }

    public EndpointDataBuilder id(Long id) {
        this.id = id;

        return this;
    }

    public EndpointDataBuilder endpoint(String endpoint) {
        this.endpoint = endpoint;

        return this;
    }

    public EndpointDataBuilder data(List<DataItem> data) {
        this.data = data;

        return this;
    }

    public EndpointData build() {
        if (isNull(endpoint) || endpoint.isEmpty()) {
            throw new IllegalStateException("Endpoint is empty");
        }
        EndpointData endpointData = new EndpointData();
        endpointData.setId(id);
        endpointData.setEndpoint(endpoint);
        endpointData.setData(data);

        return endpointData;
    }
}
