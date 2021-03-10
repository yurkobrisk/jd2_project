package it.academy.service;

import it.academy.dto.DocumentDto;
import it.academy.dto.DocumentInfoDto;
import it.academy.mapper.DocumentMapper;
import it.academy.mapper.Mapper;
import it.academy.model.Address;
import it.academy.model.ClientDocument;
import it.academy.model.Document;
import it.academy.model.ProviderDocument;
import it.academy.repository.DocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {

    private static final Logger log =
            LoggerFactory.getLogger(DocumentServiceImpl.class.getName());

    private DocumentRepository documentRepository;
    private DocumentMapper mapper;

    @Autowired
    public DocumentServiceImpl(DocumentRepository documentRepository, DocumentMapper mapper) {
        this.documentRepository = documentRepository;
        this.mapper = mapper;
    }

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

    @Override
    public Document saveDocumentDto(DocumentDto documentDto) {
        Document document = new Document();
        ClientDocument client = new ClientDocument();
        ProviderDocument provider = new ProviderDocument();
        Address addressClient = new Address();
        Address addressProvider = new Address();

        document.setClientDocument(client);
        document.setProviderDocument(provider);
        client.setClientAddress(addressClient);
        provider.setProviderAddress(addressProvider);

        document.setCreationDate(documentDto.getCreationDate());
        document.setCompletionDate(documentDto.getCompletionDate());
//        client.setClientName(documentDto.getClientName());
//        client.setClientSurname(documentDto.getClientSurname());
//        client.setClientPassportNumber(documentDto.getClientPassportNumber());
//        addressClient.setCountry(documentDto.getClientCountry());
//        addressClient.setCity(documentDto.getClientCity());
//        addressClient.setStreet(documentDto.getClientStreet());
//        addressClient.setIndex(documentDto.getClientIndex());
//        provider.setProviderName(documentDto.getProviderName());
//        provider.setProviderSurname(documentDto.getProviderSurname());
//        provider.setProviderPassportNumber(documentDto.getProviderPassportNumber());
//        addressProvider.setCountry(documentDto.getProviderCountry());
//        addressProvider.setCity(documentDto.getProviderCity());
//        addressProvider.setStreet(documentDto.getProviderStreet());
//        addressProvider.setIndex(documentDto.getProviderIndex());

        return documentRepository.saveAndFlush(document);
    }

}
