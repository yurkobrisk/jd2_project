package it.academy.service;

import it.academy.model.Document;

import java.util.List;

public interface DocumentService {

    List<Document> readAllDocuments();

    Document readDocument(String id);

    String saveDocument(Document document);

    String updateDocument(Document document);

    void deleteDocument(String id);
}
