package com.gmail.onishchenko.oleksii.prozorrorest.repository;

import com.gmail.onishchenko.oleksii.prozorrorest.entity.EndpointData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EndpointDataJpaRepository extends JpaRepository<EndpointData, Long> {
}
