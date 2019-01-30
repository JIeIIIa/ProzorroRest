package com.gmail.onishchenko.oleksii.prozorrorest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.onishchenko.oleksii.prozorrorest.dto.ResponseDto;
import com.gmail.onishchenko.oleksii.prozorrorest.entity.*;
import com.gmail.onishchenko.oleksii.prozorrorest.exception.ProzorroRestException;
import com.gmail.onishchenko.oleksii.prozorrorest.repository.EndpointDataJpaRepository;
import okhttp3.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.Validator;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class EndpointDataServiceImplTest {

    private final static String ENDPOINT = "http://endpoint.com";

    @MockBean
    private EndpointDataJpaRepository endpointDataJpaRepository;

    @MockBean
    private OkHttpClient okHttpClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Validator validator;

    private EndpointDataServiceImpl instance;

    @BeforeEach
    void setUp() {
        reset(endpointDataJpaRepository, okHttpClient);
        instance = new EndpointDataServiceImpl(endpointDataJpaRepository, okHttpClient, objectMapper, validator);
    }

    @Nested
    class Add {
        private EndpointDataServiceImpl spy;

        @BeforeEach
        void setUp() {
            spy = Mockito.spy(instance);
        }

        @Test
        void errorRetrievingData() {
            //Given
            doThrow(new ProzorroRestException()).when(spy).retrieve(any(String.class));

            //When
            assertThrows(ProzorroRestException.class, () -> spy.add(ENDPOINT));

            //Then
            verify(spy).retrieve(eq(ENDPOINT));
        }

        @Test
        void success() {
            //Given
            final DataItem first = DataItemBuilder.getInstance().id("1234567").build();
            final DataItem second = DataItemBuilder.getInstance().id("7654321").build();

            ResponseDto responseDto = new ResponseDto();
            responseDto.setData(asList(first, second));

            EndpointData expected = EndpointDataBuilder.getInstance()
                    .endpoint(ENDPOINT)
                    .data(asList(first, second))
                    .build();

            doReturn(responseDto).when(spy).retrieve(ENDPOINT);
            when(endpointDataJpaRepository.saveAndFlush(any(EndpointData.class)))
                    .thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);

            //When
            EndpointData result = spy.add(ENDPOINT);

            //Then
            assertThat(result).isNotNull()
                    .isEqualToComparingFieldByField(expected);
            verify(endpointDataJpaRepository, times(1)).saveAndFlush(eq(expected));
        }
    }

    @Test
    void FindAll() {
        //Given
        final DataItem first = DataItemBuilder.getInstance().id("1234567").build();
        final DataItem second = DataItemBuilder.getInstance().id("7654321").build();

        ResponseDto responseDto = new ResponseDto();
        responseDto.setData(asList(first, second));

        EndpointData expected = EndpointDataBuilder.getInstance()
                .endpoint(ENDPOINT)
                .data(asList(first, second))
                .build();

        doReturn(singletonList(EndpointDataBuilder.getInstance()
                .endpoint(ENDPOINT)
                .data(asList(first, second))
                .build())
        ).when(endpointDataJpaRepository).findAll();

        //When
        List<EndpointData> result = instance.findAll();

        //Then
        assertThat(result).isNotNull()
                .hasSize(1)
                .containsExactly(expected);
        verify(endpointDataJpaRepository, times(1)).findAll();
        verifyNoMoreInteractions(endpointDataJpaRepository, okHttpClient);
    }

    @Nested
    class Delete {
        private EndpointDataServiceImpl spy;
        private Long id;

        @BeforeEach
        void setUp() {
            spy = Mockito.spy(instance);
            id = 777L;
        }

        @Test
        void idIsNotPresentInDatabase() {
            //Given
            doThrow(new ProzorroRestException()).when(spy).findById(any(Long.class));

            //When
            assertThrows(ProzorroRestException.class, () -> spy.findById(id));

            //Then
            verify(spy).findById(eq(id));
        }

        @Test
        void success() {
            //Given
            final DataItem dataItem = DataItemBuilder.getInstance().id("1234567").build();

            final EndpointData endpointData = EndpointDataBuilder.getInstance()
                    .endpoint(ENDPOINT)
                    .data(singletonList(dataItem))
                    .build();
            doReturn(endpointData).when(spy).findById(eq(id));

            //When
            spy.delete(id);

            //Then
            verify(endpointDataJpaRepository, times(1)).delete(eq(endpointData));
            verifyNoMoreInteractions(endpointDataJpaRepository, okHttpClient);
        }
    }

    @Nested
    class Update {
        private EndpointDataServiceImpl spy;
        private Long id;

        @BeforeEach
        void setUp() {
            spy = Mockito.spy(instance);
            id = 777L;
        }

        @Test
        void idIsNotPresentInDatabase() {
            //Given
            doThrow(new ProzorroRestException()).when(spy).findById(any(Long.class));

            //When
            assertThrows(ProzorroRestException.class, () -> spy.findById(id));

            //Then
            verify(spy).findById(eq(id));
        }

        @Test
        void errorRetrievingData() {
            //Given
            final DataItem dataItem = DataItemBuilder.getInstance().id("1234567").build();

            final EndpointData endpointData = EndpointDataBuilder.getInstance()
                    .endpoint(ENDPOINT)
                    .data(singletonList(dataItem))
                    .build();
            doReturn(endpointData).when(spy).findById(eq(id));
            doThrow(ProzorroRestException.class).when(spy).retrieve(ENDPOINT);


            //When
            assertThrows(ProzorroRestException.class, () -> spy.update(id));

            //Then
            verify(spy).findById(eq(id));
            verify(spy).retrieve(ENDPOINT);
        }

        @Test
        void success() {
            //Given
            final DataItem dataItem = DataItemBuilder.getInstance().id("1234567").build();
            final DataItem updatedDataItem = DataItemBuilder.getInstance().id("7654321").build();
            final EndpointData expected = EndpointDataBuilder.getInstance()
                    .endpoint(ENDPOINT)
                    .data(singletonList(DataItemBuilder.getInstance().id("7654321").build()))
                    .build();
            ResponseDto responseDto = new ResponseDto();
            responseDto.setData(singletonList(updatedDataItem));

            final EndpointData endpointData = EndpointDataBuilder.getInstance()
                    .endpoint(ENDPOINT)
                    .data(singletonList(dataItem))
                    .build();
            doReturn(endpointData).when(spy).findById(eq(id));
            doReturn(responseDto).when(spy).retrieve(ENDPOINT);
            when(endpointDataJpaRepository.saveAndFlush(any(EndpointData.class)))
                    .thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);

            //When
            EndpointData result = spy.update(id);

            //Then
            assertThat(result).isNotNull()
                    .isEqualTo(expected);
            verify(spy).findById(eq(id));
            verify(spy).retrieve(ENDPOINT);
            verify(endpointDataJpaRepository, times(1)).saveAndFlush(eq(expected));
            verifyNoMoreInteractions(endpointDataJpaRepository, okHttpClient);
        }
    }

    static class DataItemJson implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
            return Stream.of(
                    Arguments.of("{\"data\":[{\"hash\":\"hashCode\"}]}"),
                    Arguments.of("{\"hash\":\"hashCode\"}")
            );
        }
    }

    @Nested
    class Retrieve implements DataItemSource {
        private Call call;
        private Response response;

        @BeforeEach
        void setUp() {
            call = mock(Call.class);
            response = mock(Response.class);

            when(okHttpClient.newCall(any(Request.class))).thenReturn(call);
        }

        @Test
        void errorRequestExecution() throws IOException {
            //Given
            when(call.execute()).thenThrow(IOException.class);

            //When
            assertThrows(ProzorroRestException.class, () -> instance.retrieve(ENDPOINT));

            //Then
            verify(okHttpClient, times(1)).newCall(any(Request.class));
            verify(call, times(1)).execute();
            verifyNoMoreInteractions(endpointDataJpaRepository);
        }

        @Test
        void wrongResponseStatus() throws IOException {
            //Given
            when(call.execute()).thenReturn(response);
            when(response.isSuccessful()).thenReturn(false);

            //When
            assertThrows(ProzorroRestException.class, () -> instance.retrieve(ENDPOINT));

            //Then
            verify(okHttpClient, times(1)).newCall(any(Request.class));
            verify(call, times(1)).execute();
            verifyNoMoreInteractions(endpointDataJpaRepository);
        }

        @Test
        void responseBodyIsNull() throws IOException {
            //Given
            when(call.execute()).thenReturn(response);
            when(response.isSuccessful()).thenReturn(true);

            //When
            assertThrows(ProzorroRestException.class, () -> instance.retrieve(ENDPOINT));

            //Then
            verify(okHttpClient, times(1)).newCall(any(Request.class));
            verify(call, times(1)).execute();
            verifyNoMoreInteractions(endpointDataJpaRepository);
        }

        @ParameterizedTest
        @ArgumentsSource(DataItemJson.class)
        void responseBodyWithWrongData(String json) throws IOException {
            //Given
            ResponseBody responseBody = mock(ResponseBody.class);
            when(call.execute()).thenReturn(response);
            when(response.isSuccessful()).thenReturn(true);
            when(response.body()).thenReturn(responseBody);
            when(responseBody.string()).thenReturn(json);

            //When
            assertThrows(ProzorroRestException.class, () -> instance.retrieve(ENDPOINT));

            //Then
            verify(okHttpClient, times(1)).newCall(any(Request.class));
            verify(call, times(1)).execute();
            verifyNoMoreInteractions(endpointDataJpaRepository);
        }

        @Test
        void success() throws IOException {
            //Given
            String json = dataItemSourceFirst()
                    .map(Map.Entry::getValue)
                    .collect(Collectors.joining(",", "{\"data\":[", "]}"));
            DataItem[] expectedData = dataItemSourceFirst()
                    .map(Map.Entry::getKey)
                    .toArray(DataItem[]::new);
            ResponseBody responseBody = mock(ResponseBody.class);
            when(call.execute()).thenReturn(response);
            when(response.isSuccessful()).thenReturn(true);
            when(response.body()).thenReturn(responseBody);
            when(responseBody.string()).thenReturn(json);

            //When
            ResponseDto responseDto = instance.retrieve(ENDPOINT);

            //Then
            assertThat(responseDto).isNotNull();
            assertThat(responseDto.getData()).isNotNull()
                    .hasSize(expectedData.length)
                    .containsExactlyInAnyOrder(expectedData);

            verify(okHttpClient, times(1)).newCall(any(Request.class));
            verify(call, times(1)).execute();
            verifyNoMoreInteractions(endpointDataJpaRepository);
        }
    }

    @Nested
    class FindById {
        @Test
        void failure() {
            //Given
            Long id = 777L;
            when(endpointDataJpaRepository.findById(id)).thenReturn(Optional.empty());

            //When
            assertThrows(ProzorroRestException.class, () -> instance.findById(id));

            //Then
            verify(endpointDataJpaRepository, times(1)).findById(id);
            verifyNoMoreInteractions(endpointDataJpaRepository, okHttpClient);
        }

        @Test
        void success() {
            //Given
            Long id = 777L;
            final EndpointData endpointData = EndpointDataBuilder.getInstance().endpoint(ENDPOINT).id(123L).build();
            final EndpointData expected = EndpointDataBuilder.getInstance().endpoint(ENDPOINT).id(123L).build();
            when(endpointDataJpaRepository.findById(id)).thenReturn(ofNullable(endpointData));

            //When
            EndpointData result = instance.findById(id);

            //Then
            assertThat(result).isNotNull()
                    .isEqualTo(expected);
            verify(endpointDataJpaRepository, times(1)).findById(id);
            verifyNoMoreInteractions(endpointDataJpaRepository, okHttpClient);
        }
    }
}

