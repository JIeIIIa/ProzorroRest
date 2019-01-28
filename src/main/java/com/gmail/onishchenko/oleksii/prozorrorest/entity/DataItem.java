package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity(name = "data_item")
@Table(name = "data_item")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DataItem {
    private static final String DATE_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSSSSSXXX";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInDB;

    @NotEmpty
    private String hash;

    private Language language;

    private String description;

    private Format format;

    @NotEmpty
    private String url;

    private String title;

    private DocumentOf documentOf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DATE_PATTERN)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime datePublished;

    @JsonFormat(pattern = DATE_PATTERN)
    @JsonDeserialize(using = ZonedDateTimeDeserializer.class)
    private ZonedDateTime dateModified;

    private DocumentType documentType;

    @NotEmpty
    private String id;

    private String relatedItem;

    public Long getIdInDB() {
        return idInDB;
    }

    public void setIdInDB(Long idInDB) {
        this.idInDB = idInDB;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DocumentOf getDocumentOf() {
        return documentOf;
    }

    public void setDocumentOf(DocumentOf documentOf) {
        this.documentOf = documentOf;
    }

    public ZonedDateTime getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(ZonedDateTime datePublished) {
        this.datePublished = datePublished;
    }

    public ZonedDateTime getDateModified() {
        return dateModified;
    }

    public void setDateModified(ZonedDateTime dateModified) {
        this.dateModified = dateModified;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelatedItem() {
        return relatedItem;
    }

    public void setRelatedItem(String relatedItem) {
        this.relatedItem = relatedItem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataItem dataItem = (DataItem) o;
        return Objects.equals(idInDB, dataItem.idInDB) &&
                Objects.equals(hash, dataItem.hash) &&
                language == dataItem.language &&
                Objects.equals(description, dataItem.description) &&
                format == dataItem.format &&
                Objects.equals(url, dataItem.url) &&
                Objects.equals(title, dataItem.title) &&
                documentOf == dataItem.documentOf &&
                Objects.equals(datePublished, dataItem.datePublished) &&
                Objects.equals(dateModified, dataItem.dateModified) &&
                documentType == dataItem.documentType &&
                Objects.equals(id, dataItem.id) &&
                Objects.equals(relatedItem, dataItem.relatedItem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInDB, hash, language, description, format, url, title, documentOf, datePublished, dateModified, documentType, id, relatedItem);
    }
}
