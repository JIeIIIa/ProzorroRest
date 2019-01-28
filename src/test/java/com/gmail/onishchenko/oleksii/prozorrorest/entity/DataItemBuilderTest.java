package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DataItemBuilderTest {

    static LongStream longs() {
        return ThreadLocalRandom.current().longs(5, 1, Long.MAX_VALUE);
    }

    static Stream<String> strings() {
        return Stream.of(
                "first",
                "second",
                "value",
                "Awesome String"
        );
    }

    static Stream<ZonedDateTime> dates() {
        return Stream.of(
                ZonedDateTime.of(2019, 1, 27, 10, 57, 19, 34, ZoneId.of(ZoneId.SHORT_IDS.get("ECT"))),
                ZonedDateTime.of(2019, 1, 27, 10, 57, 19, 34, ZoneId.of(ZoneId.SHORT_IDS.get("PNT"))),
                ZonedDateTime.of(2019, 1, 27, 10, 57, 19, 34, ZoneId.of(ZoneId.SHORT_IDS.get("EST")))
        );
    }

    @ParameterizedTest(name = "[{index}] ==> idInDB = ''{0}''")
    @MethodSource(value = {"longs"})
    void idInDB(Long idInDB) {
        //When
        DataItem dataItem = DataItemBuilder.getInstance().idInDB(idInDB).build();

        //Then
        assertThat(dataItem.getIdInDB()).isEqualTo(idInDB);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "idInDB");
    }

    @ParameterizedTest(name = "[{index}] ==> hash = ''{0}''")
    @MethodSource(value = {"strings"})
    void hash(String hash) {
        //When
        DataItem dataItem = DataItemBuilder.getInstance().hash(hash).build();

        //Then
        assertThat(dataItem.getHash()).isEqualTo(hash);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "hash");
    }

    @Test
    void language() {
        //Given
        Language language = Language.UK;

        //When
        DataItem dataItem = DataItemBuilder.getInstance().language(language).build();

        //Then
        assertThat(dataItem.getLanguage()).isEqualTo(language);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "language");
    }

    @ParameterizedTest(name = "[{index}] ==> description = ''{0}''")
    @MethodSource(value = {"strings"})
    void description(String description) {
        //When
        DataItem dataItem = DataItemBuilder.getInstance().description(description).build();

        //Then
        assertThat(dataItem.getDescription()).isEqualTo(description);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "description");
    }

    @Test
    void format() {
        //Given
        Format format = Format.APPLICATION_PKCS7_SIGNATURE;

        //When
        DataItem dataItem = DataItemBuilder.getInstance().format(format).build();

        //Then
        assertThat(dataItem.getFormat()).isEqualTo(format);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "format");
    }

    @ParameterizedTest(name = "[{index}] ==> url = ''{0}''")
    @MethodSource(value = {"strings"})
    void url(String url) {
        //When
        DataItem dataItem = DataItemBuilder.getInstance().url(url).build();

        //Then
        assertThat(dataItem.getUrl()).isEqualTo(url);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "url");
    }

    @ParameterizedTest(name = "[{index}] ==> title = ''{0}''")
    @MethodSource(value = {"strings"})
    void title(String title) {
        //When
        DataItem dataItem = DataItemBuilder.getInstance().title(title).build();

        //Then
        assertThat(dataItem.getTitle()).isEqualTo(title);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "title");
    }

    @Test
    void documentOf() {
        //Given
        DocumentOf documentOf = DocumentOf.CONTRACT;

        //When
        DataItem dataItem = DataItemBuilder.getInstance().documentOf(documentOf).build();

        //Then
        assertThat(dataItem.getDocumentOf()).isEqualTo(documentOf);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "documentOf");
    }

    @ParameterizedTest(name = "[{index}] ==> datePublished = ''{0}''")
    @MethodSource(value = {"dates"})
    void datePublished(ZonedDateTime datePublished) {
        //When
        DataItem dataItem = DataItemBuilder.getInstance().datePublished(datePublished).build();

        //Then
        assertThat(dataItem.getDatePublished()).isEqualTo(datePublished);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "datePublished");
    }

    @ParameterizedTest(name = "[{index}] ==> dateModified = ''{0}''")
    @MethodSource(value = {"dates"})
    void dateModified(ZonedDateTime dateModified) {
        //When
        DataItem dataItem = DataItemBuilder.getInstance().dateModified(dateModified).build();

        //Then
        assertThat(dataItem.getDateModified()).isEqualTo(dateModified);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "dateModified");
    }

    @Test
    void documentType() {
        //Given
        DocumentType documentType = DocumentType.CONTRACT_ANNEXE;

        //When
        DataItem dataItem = DataItemBuilder.getInstance().documentType(documentType).build();

        //Then
        assertThat(dataItem.getDocumentType()).isEqualTo(documentType);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "documentType");
    }

    @ParameterizedTest(name = "[{index}] ==> id = ''{0}''")
    @MethodSource(value = {"strings"})
    void id(String id) {
        //When
        DataItem dataItem = DataItemBuilder.getInstance().id(id).build();

        //Then
        assertThat(dataItem.getId()).isEqualTo(id);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "id");
    }

    @ParameterizedTest(name = "[{index}] ==> relatedItem = ''{0}''")
    @MethodSource(value = {"strings"})
    void relatedItem(String relatedItem) {
        //When
        DataItem dataItem = DataItemBuilder.getInstance().relatedItem(relatedItem).build();

        //Then
        assertThat(dataItem.getRelatedItem()).isEqualTo(relatedItem);
        assertThat(dataItem).isEqualToIgnoringGivenFields(new DataItem(), "relatedItem");
    }
}