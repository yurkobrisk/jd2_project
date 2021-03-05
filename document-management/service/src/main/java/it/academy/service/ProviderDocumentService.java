package it.academy.service;

import it.academy.model.ProviderDocument;

import java.util.List;

public interface ProviderDocumentService {

    List<ProviderDocument> readAllProviders();

    ProviderDocument readProviderDocument(String id);

    ProviderDocument saveProviderDocument(ProviderDocument providerDocument);

    ProviderDocument updateProviderDocument(ProviderDocument providerDocument);

    void deleteProviderDocument(String id);
}
