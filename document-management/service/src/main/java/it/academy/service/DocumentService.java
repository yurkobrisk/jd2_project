package it.academy.service;

import it.academy.model.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DocumentService {

    List<Document> readAllDocuments();

    Page<Document> readAllDocuments(Pageable pageable);

    Document readDocument(String id);

    Document saveDocument(Document document);

    Document updateDocument(Document document);

    void deleteDocument(String id);

}
