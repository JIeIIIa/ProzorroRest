package com.gmail.onishchenko.oleksii.prozorrorest.service;

import com.gmail.onishchenko.oleksii.prozorrorest.entity.EndpointData;

import java.util.List;

public interface EndpointDataService {
    EndpointData add(String endpoint);

    List<EndpointData> retrieveAll();

    void delete(Long id);

    EndpointData update(Long id);
}
