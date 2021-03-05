package it.academy.service;

import it.academy.model.FileDocument;
import it.academy.repository.FileDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileDocumentServiceImpl implements FileDocumentService {

    private static final Logger log =
            LoggerFactory.getLogger(FileDocumentServiceImpl.class);

    @Autowired
    private FileDocumentRepository fileDocumentRepository;

    @Override
    public List<FileDocument> readAllFileDocuments() {
        return fileDocumentRepository.findAll();
    }

    @Override
    public FileDocument readFileDocument(String id) {
        return fileDocumentRepository.getOne(id);
    }

    @Override
    public FileDocument saveFileDocument(FileDocument fileDocument) {
        return fileDocumentRepository.saveAndFlush(fileDocument);
    }

    @Override
    public FileDocument updateFileDocument(FileDocument fileDocument) {
        return fileDocumentRepository.saveAndFlush(fileDocument);
    }

    @Override
    public void deleteFileDocument(String id) {
        fileDocumentRepository.deleteById(id);
    }
}
