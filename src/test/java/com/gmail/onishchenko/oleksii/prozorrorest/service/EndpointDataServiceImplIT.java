package com.gmail.onishchenko.oleksii.prozorrorest.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.gmail.onishchenko.oleksii.prozorrorest.configuration.DBUnitConfiguration;
import com.gmail.onishchenko.oleksii.prozorrorest.entity.*;
import com.gmail.onishchenko.oleksii.prozorrorest.repository.EndpointDataJpaRepository;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.dbunit.database.IDatabaseConnection;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Validator;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ContextConfiguration(classes = {DBUnitConfiguration.class})
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
@DatabaseSetup(value = "classpath:datasets/EndpointDataJpaRepository/init_dataset.xml")
@Transactional
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class EndpointDataServiceImplIT implements DataItemSource {

    @Autowired
    private IDatabaseConnection connection;

    @Autowired
    private EndpointDataJpaRepository repository;

    private OkHttpClient okHttpClient = mock(OkHttpClient.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Validator validator;

    private EndpointDataServiceImpl instance;

    @BeforeEach
    void setUp() throws SQLException {
        Statement statement = connection.getConnection().createStatement();
        statement.execute("alter sequence  endpoint_data_id_seq RESTART WITH 1");
        statement.execute("alter sequence  data_item_id_in_db_seq RESTART WITH 1");

        reset(okHttpClient);
        instance = new EndpointDataServiceImpl(repository, okHttpClient, objectMapper, validator);
    }

    @Test
    void findById() {
        //Given
        DataItem dataItem = DataItemBuilder.getInstance()
                .idInDB(-100002L)
                .dateModified(ZonedDateTime.parse("2018-10-08T15:13:06.456152+03:00"))
                .datePublished(ZonedDateTime.parse("2018-10-08T15:13:06.456131+03:00"))
                .description("WoW")
                .documentOf(DocumentOf.TENDER)
                .documentType(DocumentType.CONTRACT_SIGNED)
                .format(Format.APPLICATION_VND_OPENXMLFORMATS_OFFICEDOCUMENT_SPREADSHEETML)
                .hash("md5:787caaf33e54d10e6cd302bce098564c")
                .id("c973e26efa78408c8cf7adbb3c2b11e5")
                .language(Language.UK)
                .relatedItem("related")
                .title("Додаткова угода.xlsx")
                .url("https://public-docs-sandbox.prozorro.gov.ua/get/69966a5cbdf94ea")
                .build();
        EndpointData endpointData = EndpointDataBuilder.getInstance().id(-100002L)
                .endpoint("http:/pretty.endpoint")
                .data(singletonList(dataItem))
                .build();

        //When
        EndpointData result = instance.findById(-100002L);

        //Then
        assertThat(result).isEqualToIgnoringGivenFields(endpointData, "data");
        assertThat(result.getData()).usingElementComparatorIgnoringFields("dateModified", "datePublished")
                .containsExactlyInAnyOrder(dataItem);
        assertThat(result.getData().get(0).getDatePublished())
                .isEqualTo(dataItem.getDatePublished());
        assertThat(result.getData().get(0).getDateModified())
                .isEqualTo(dataItem.getDateModified());
    }

    @Test
    void findAll() {
        //When
        List<EndpointData> all = instance.findAll();

        //Then
        assertThat(all).isNotNull()
                .hasSize(3);
    }

    @Test
    @ExpectedDatabase("classpath:datasets/EndpointDataJpaRepository/after_added_dataset.xml")
    void add() throws IOException {
        //Given
        String endpoint = "http:/new.endpoint";
        Call call = mock(Call.class);
        Response response = mock(Response.class);
        ResponseBody responseBody = mock(ResponseBody.class);
        String json = dataItemSourceThird()
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(",", "{\"data\":[", "]}"));

        when(okHttpClient.newCall(any())).thenReturn(call);
        when(call.execute()).thenReturn(response);
        when(response.isSuccessful()).thenReturn(true);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.string()).thenReturn(json);

        //When
        EndpointData endpointData = instance.add(endpoint);

        //Then
        assertThat(endpointData).isNotNull();
        assertThat(endpointData.getEndpoint()).isEqualTo(endpoint);
        assertThat(endpointData.getData()).hasSize(3);
    }

    @Test
    @ExpectedDatabase("classpath:datasets/EndpointDataJpaRepository/after_updated_dataset.xml")
    void update() throws IOException {
        //Given
        String endpoint = "http:/should.be.updated.endpoint";
        Call call = mock(Call.class);
        Response response = mock(Response.class);
        ResponseBody responseBody = mock(ResponseBody.class);
        String json = dataItemSourceThird()
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(",", "{\"data\":[", "]}"));

        when(okHttpClient.newCall(any())).thenReturn(call);
        when(call.execute()).thenReturn(response);
        when(response.isSuccessful()).thenReturn(true);
        when(response.body()).thenReturn(responseBody);
        when(responseBody.string()).thenReturn(json);

        //When
        EndpointData endpointData = instance.update(-100000L);

        //Then
        assertThat(endpointData).isNotNull();
        assertThat(endpointData.getEndpoint()).isEqualTo(endpoint);
        assertThat(endpointData.getData()).hasSize(3);
    }

    @Test
    @ExpectedDatabase("classpath:datasets/EndpointDataJpaRepository/after_deleted_dataset.xml")
    void delete() {
        //When
        instance.delete(-100001L);
        repository.flush();
    }

}