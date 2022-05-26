package it.academy.service;

import it.academy.model.Document;
import it.academy.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    private static final Logger log =
            LoggerFactory.getLogger(DocumentServiceImpl.class.getName());

    @Autowired
    private DocumentRepository documentRepository;

    @Override
    public List<Document> readAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Page<Document> readAllDocuments(Pageable pageable) {
        return documentRepository.findAll(pageable);
    }

    @Override
    public Document readDocument(String id) {
        return documentRepository.getOne(id);
    }

    @Override
    public Document saveDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public Document updateDocument(Document document) {
        return documentRepository.save(document);
    }

    @Override
    public void deleteDocument(String id) {
        documentRepository.deleteById(id);
    }


}
