package it.academy.service;

import it.academy.model.ClientDocument;

import java.util.List;

public interface ClientDocumentService {

    List<ClientDocument> readAllClients();

    ClientDocument readClientDocument(String id);

    ClientDocument saveClientDocument(ClientDocument clientDocument);

    ClientDocument updateClientDocument(ClientDocument clientDocument);

    void deleteClientDocument(String id);
}
