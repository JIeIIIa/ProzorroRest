package com.gmail.onishchenko.oleksii.prozorrorest.controller;

import com.gmail.onishchenko.oleksii.prozorrorest.entity.DataItem;
import com.gmail.onishchenko.oleksii.prozorrorest.entity.DataItemBuilder;
import com.gmail.onishchenko.oleksii.prozorrorest.entity.EndpointData;
import com.gmail.onishchenko.oleksii.prozorrorest.entity.EndpointDataBuilder;
import com.gmail.onishchenko.oleksii.prozorrorest.exception.ProzorroRestException;
import com.gmail.onishchenko.oleksii.prozorrorest.service.EndpointDataService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {EndpointDataController.class, MainAdviceController.class})
class EndpointDataControllerTest {
    private static final String URL = "/endpoints";

    private static final String ENDPOINT = "http://endpoint.com";

    @MockBean
    private EndpointDataService endpointDataService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        reset(endpointDataService);
    }

    @Nested
    class Add {
        MockHttpServletRequestBuilder post;

        @BeforeEach
        void setUp() {
            post = MockMvcRequestBuilders.post(URL)
                    .flashAttr("url", ENDPOINT);
        }

        @Test
        void failure() throws Exception {
            //Given
            when(endpointDataService.add(ENDPOINT)).thenThrow(ProzorroRestException.class);

            //When
            ResultActions perform = mockMvc.perform(post);

            //Then
            perform.andExpect(status().isBadRequest());
        }

        @Test
        void success() throws Exception {
            //Given
            DataItem dataItem = DataItemBuilder.getInstance()
                    .hash("qwerty")
                    .idInDB(777L)
                    .id("asdfgh")
                    .build();
            EndpointData endpointData = EndpointDataBuilder.getInstance()
                    .id(123L)
                    .endpoint(ENDPOINT)
                    .data(singletonList(dataItem))
                    .build();
            when(endpointDataService.add(ENDPOINT)).thenReturn(endpointData);

            //When
            ResultActions perform = mockMvc.perform(post);

            //Then
            perform.andExpect(status().isOk())
                    .andExpect(jsonPath("id", is(123)))
                    .andExpect(jsonPath("endpoint", is(ENDPOINT)))
                    .andExpect(jsonPath("data", hasSize(1)))
                    .andExpect(jsonPath("data[0].hash", is("qwerty")))
                    .andExpect(jsonPath("data[0].idInDB", is(777)))
                    .andExpect(jsonPath("data[0].id", is("asdfgh")));
        }
    }

    @Nested
    class Delete {
        Long id;
        MockHttpServletRequestBuilder delete;

        @BeforeEach
        void setUp() {
            id = 7L;
            delete = MockMvcRequestBuilders.delete(URL + "/" + id);
        }
        @Test
        void failure() throws Exception {
            //Given
            doThrow(ProzorroRestException.class).when(endpointDataService).delete(id);

            //When
            ResultActions perform = mockMvc.perform(delete);

            //Then
            perform.andExpect(status().isBadRequest());
        }

        @Test
        void success() throws Exception {
            //When
            ResultActions perform = mockMvc.perform(delete);

            //Then
            perform.andExpect(status().isOk());
        }
    }

    @Nested
    class Update {
        Long id;
        MockHttpServletRequestBuilder put;

        @BeforeEach
        void setUp() {
            id = 7L;
            put = MockMvcRequestBuilders.put(URL + "/" + id);
        }

        @Test
        void failure() throws Exception {
            //Given
            when(endpointDataService.update(id)).thenThrow(ProzorroRestException.class);

            //When
            ResultActions perform = mockMvc.perform(put);

            //Then
            perform.andExpect(status().isBadRequest());
        }

        @Test
        void success() throws Exception {
            //Given
            DataItem dataItem = DataItemBuilder.getInstance()
                    .hash("qwerty")
                    .idInDB(777L)
                    .id("asdfgh")
                    .build();
            EndpointData endpointData = EndpointDataBuilder.getInstance()
                    .id(321L)
                    .endpoint(ENDPOINT)
                    .data(singletonList(dataItem))
                    .build();
            when(endpointDataService.update(id)).thenReturn(endpointData);

            //When
            ResultActions perform = mockMvc.perform(put);

            //Then
            perform.andExpect(status().isOk())
                    .andExpect(jsonPath("id", is(321)))
                    .andExpect(jsonPath("endpoint", is(ENDPOINT)))
                    .andExpect(jsonPath("data", hasSize(1)))
                    .andExpect(jsonPath("data[0].hash", is("qwerty")))
                    .andExpect(jsonPath("data[0].idInDB", is(777)))
                    .andExpect(jsonPath("data[0].id", is("asdfgh")));
        }
    }

    @Test
    void all() throws Exception {
        //Given
        DataItem dataItem = DataItemBuilder.getInstance()
                .hash("qwerty")
                .idInDB(777L)
                .id("asdfgh")
                .build();
        EndpointData endpointData = EndpointDataBuilder.getInstance()
                .id(321L)
                .endpoint(ENDPOINT)
                .data(singletonList(dataItem))
                .build();
        when(endpointDataService.retrieveAll()).thenReturn(singletonList(endpointData));
        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get(URL);

        //When
        ResultActions perform = mockMvc.perform(get);

        //Then
        perform.andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(321)))
                .andExpect(jsonPath("$[0].endpoint", is(ENDPOINT)))
                .andExpect(jsonPath("$[0].data", hasSize(1)))
                .andExpect(jsonPath("$[0].data[0].hash", is("qwerty")))
                .andExpect(jsonPath("$[0].data[0].idInDB", is(777)))
                .andExpect(jsonPath("$[0].data[0].id", is("asdfgh")));
    }
}