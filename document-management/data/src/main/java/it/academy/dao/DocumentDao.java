package it.academy.dao;

import it.academy.model.Document;

import java.util.List;

public interface DocumentDao {

    List<Document> findAllDocuments();

    Document read(String id);

    String save(Document document);

    Document delete(String id);
}
