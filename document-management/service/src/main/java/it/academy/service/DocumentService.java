package it.academy.service;

import it.academy.model.Document;

import java.util.List;

public interface DocumentService {

    List<Document> readAllDocuments();

    Document readDocument(String id);

    Document saveDocument(Document document);

    Document updateDocument(Document document);

    void deleteDocument(String id);
}
