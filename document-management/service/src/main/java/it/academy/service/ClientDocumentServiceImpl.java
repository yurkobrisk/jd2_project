package it.academy.service;

import it.academy.model.ClientDocument;
import it.academy.repository.ClientDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientDocumentServiceImpl implements ClientDocumentService {

    private static final Logger log =
            LoggerFactory.getLogger(ClientDocumentServiceImpl.class);

    @Autowired
    private ClientDocumentRepository clientDocumentRepository;

    @Override
    public List<ClientDocument> readAllClients() {
        return clientDocumentRepository.findAll();
    }

    @Override
    public ClientDocument readClientDocument(String id) {
        return clientDocumentRepository.getOne(id);
    }

    @Override
    public ClientDocument saveClientDocument(ClientDocument clientDocument) {
        return clientDocumentRepository.saveAndFlush(clientDocument);
    }

    @Override
    public ClientDocument updateClientDocument(ClientDocument clientDocument) {
        return clientDocumentRepository.saveAndFlush(clientDocument);
    }

    @Override
    public void deleteClientDocument(String id) {
        clientDocumentRepository.deleteById(id);
    }
}
