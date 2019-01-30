package com.gmail.onishchenko.oleksii.prozorrorest.service;

import com.gmail.onishchenko.oleksii.prozorrorest.entity.EndpointData;

import java.util.List;

public interface EndpointDataService {
    EndpointData findById(Long id);

    List<EndpointData> findAll();

    EndpointData add(String endpoint);

    void delete(Long id);

    EndpointData update(Long id);
}
