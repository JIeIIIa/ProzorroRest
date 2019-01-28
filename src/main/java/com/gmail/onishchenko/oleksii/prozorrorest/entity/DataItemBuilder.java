package com.gmail.onishchenko.oleksii.prozorrorest.entity;

import java.time.ZonedDateTime;

public class DataItemBuilder {
    private Long idInDB;

    private String hash;

    private Language language;

    private String description;

    private Format format;

    private String url;

    private String title;

    private DocumentOf documentOf;

    private ZonedDateTime datePublished;

    private ZonedDateTime dateModified;

    private DocumentType documentType;

    private String id;

    private String relatedItem;

    private DataItemBuilder() {
    }

    public static DataItemBuilder getInstance() {
        return new DataItemBuilder();
    }

    public DataItemBuilder idInDB(Long idInDB) {
        this.idInDB = idInDB;

        return this;
    }

    public DataItemBuilder hash(String hash) {
        this.hash = hash;

        return this;
    }

    public DataItemBuilder language(Language language) {
        this.language = language;

        return this;
    }

    public DataItemBuilder description(String description) {
        this.description = description;

        return this;
    }

    public DataItemBuilder format(Format format) {
        this.format = format;

        return this;
    }

    public DataItemBuilder url(String url) {
        this.url = url;

        return this;
    }

    public DataItemBuilder title(String title) {
        this.title = title;

        return this;
    }

    public DataItemBuilder documentOf(DocumentOf documentOf) {
        this.documentOf = documentOf;

        return this;
    }

    public DataItemBuilder datePublished(ZonedDateTime datePublished) {
        this.datePublished = datePublished;

        return this;
    }

    public DataItemBuilder dateModified(ZonedDateTime dateModified) {
        this.dateModified = dateModified;

        return this;
    }

    public DataItemBuilder documentType(DocumentType documentType) {
        this.documentType = documentType;

        return this;
    }

    public DataItemBuilder id(String id) {
        this.id = id;

        return this;
    }

    public DataItemBuilder relatedItem(String relatedItem) {
        this.relatedItem = relatedItem;

        return this;
    }

    public DataItem build() {
        DataItem dataItem = new DataItem();
        dataItem.setIdInDB(idInDB);
        dataItem.setHash(hash);
        dataItem.setLanguage(language);
        dataItem.setDescription(description);
        dataItem.setFormat(format);
        dataItem.setUrl(url);
        dataItem.setTitle(title);
        dataItem.setDocumentOf(documentOf);
        dataItem.setDatePublished(datePublished);
        dataItem.setDateModified(dateModified);
        dataItem.setDocumentType(documentType);
        dataItem.setId(id);
        dataItem.setRelatedItem(relatedItem);

        return dataItem;
    }
}
