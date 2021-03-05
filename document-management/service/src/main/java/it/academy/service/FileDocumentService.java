package it.academy.service;

import it.academy.model.FileDocument;

import java.util.List;

public interface FileDocumentService {

    List<FileDocument> readAllFileDocuments();

    FileDocument readFileDocument(String id);

    FileDocument saveFileDocument(FileDocument fileDocument);

    FileDocument updateFileDocument(FileDocument fileDocument);

    void deleteFileDocument(String id);
}
