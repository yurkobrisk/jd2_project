package it.academy.service;

import it.academy.model.Document;
import it.academy.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {

    private static final Logger log =
            LoggerFactory.getLogger(DocumentServiceImpl.class);

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> readAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document readDocument(String id) {
        return documentRepository.getOne(id);
    }

    @Override
    public Document saveDocument(Document document) {
        return documentRepository.saveAndFlush(document);
    }

    @Override
    public Document updateDocument(Document document) {
        return documentRepository.saveAndFlush(document);
    }

    @Override
    public void deleteDocument(String id) {
        documentRepository.deleteById(id);
    }
}
