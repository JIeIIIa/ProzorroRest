package com.gmail.onishchenko.oleksii.prozorrorest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.onishchenko.oleksii.prozorrorest.dto.ResponseDto;
import com.gmail.onishchenko.oleksii.prozorrorest.entity.EndpointData;
import com.gmail.onishchenko.oleksii.prozorrorest.entity.EndpointDataBuilder;
import com.gmail.onishchenko.oleksii.prozorrorest.exception.ProzorroRestException;
import com.gmail.onishchenko.oleksii.prozorrorest.repository.EndpointDataJpaRepository;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class EndpointDataServiceImpl implements EndpointDataService {

    private static final Logger LOG = LogManager.getLogger(EndpointDataServiceImpl.class);

    private final EndpointDataJpaRepository endpointDataJpaRepository;

    private final OkHttpClient okHttpClient;

    private final ObjectMapper objectMapper;

    private final Validator validator;

    @Autowired
    public EndpointDataServiceImpl(EndpointDataJpaRepository endpointDataJpaRepository,
                                   OkHttpClient okHttpClient,
                                   ObjectMapper objectMapper,
                                   Validator validator) {
        LOG.debug("Create instance of {}", EndpointDataServiceImpl.class.getName());
        this.endpointDataJpaRepository = endpointDataJpaRepository;
        this.okHttpClient = okHttpClient;
        this.objectMapper = objectMapper;
        this.validator = validator;
    }

    @Override
    @Transactional(readOnly = true)
    public EndpointData findById(Long id) {
        LOG.traceEntry("id = {}", id);
        return endpointDataJpaRepository
                .findById(id)
                .orElseThrow(() -> new ProzorroRestException("Entity not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<EndpointData> findAll() {
        LOG.traceEntry();
        return LOG.traceExit(endpointDataJpaRepository.findAll());
    }

    @Override
    @Transactional
    public EndpointData add(String endpoint) {
        LOG.traceEntry("{}", endpoint);
        ResponseDto responseDto = retrieve(endpoint);
        EndpointData endpointData = EndpointDataBuilder.getInstance()
                .endpoint(endpoint)
                .data(responseDto.getData())
                .build();
        return LOG.traceExit(endpointDataJpaRepository.saveAndFlush(endpointData));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        LOG.traceEntry("id = {}", id);
        EndpointData endpointData = findById(id);
        endpointDataJpaRepository.delete(endpointData);
        LOG.traceExit("Data was deleted: id = {}", id);
    }

    @Override
    public EndpointData update(Long id) {
        LOG.traceEntry("id = {}", id);
        EndpointData endpointData = findById(id);
        ResponseDto responseDto = retrieve(endpointData.getEndpoint());
        endpointData.setData(responseDto.getData());
        return LOG.traceExit("Data was updated: {}", endpointDataJpaRepository.saveAndFlush(endpointData));
    }

    ResponseDto retrieve(String endpoint) {
        LOG.entry("endpoint = {}", endpoint);
        Request request = new Request.Builder()
                .url(endpoint)
                .build();

        ResponseDto responseDto;
        try {
            LOG.debug("Sending request");
            Response response = okHttpClient.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new ProzorroRestException("The response from the external rest server has illegal status");
            }
            ResponseBody body = response.body();
            if (Objects.isNull(body)) {
                throw new ProzorroRestException("The response from the external rest server has no body");
            }
            String json = body.string();
            LOG.trace("response: {}", json);
            LOG.trace("Mapping json to responseDTO");
            responseDto = objectMapper.readValue(json, ResponseDto.class);
            validate(responseDto);
        } catch (IOException e) {
            throw new ProzorroRestException("Error retrieving data from the external rest server");
        }
        return LOG.traceExit(responseDto);
    }

    private void validate(ResponseDto responseDto) {
        LOG.debug("Validate object: {}", responseDto);
        if (Objects.isNull(responseDto.getData())) {
            throw new ProzorroRestException("Response object has no data");
        }
        long count = responseDto.getData().stream()
                .map(r -> validator.validate(r))
                .map(Set::size)
                .mapToInt(Integer::intValue)
                .sum();
        if (count != 0) {
            throw new ProzorroRestException("Validation data error");
        }
        LOG.debug("Response object is valid");
    }
}
