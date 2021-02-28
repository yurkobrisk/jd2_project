package it.academy.dao;

import it.academy.model.Document;

import java.util.List;

public interface DocumentDao {

    List<Document> readAllDocuments();

    Document readDocument(String id);

    String saveDocument(Document document);

    String updateDocument(Document document);

    void deleteDocument(String id);
}
