package it.academy.service;

import it.academy.model.ProviderDocument;
import it.academy.repository.ProviderDocumentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderDocumentServiceImpl implements ProviderDocumentService {

    private static final Logger log =
            LoggerFactory.getLogger(ProviderDocumentServiceImpl.class);

    @Autowired
    private ProviderDocumentRepository providerDocumentRepository;

    @Override
    public List<ProviderDocument> readAllProviders() {
        return providerDocumentRepository.findAll();
    }

    @Override
    public ProviderDocument readProviderDocument(String id) {
        return providerDocumentRepository.getOne(id);
    }

    @Override
    public ProviderDocument saveProviderDocument(ProviderDocument providerDocument) {
        return providerDocumentRepository.saveAndFlush(providerDocument);
    }

    @Override
    public ProviderDocument updateProviderDocument(ProviderDocument providerDocument) {
        return providerDocumentRepository.saveAndFlush(providerDocument);
    }

    @Override
    public void deleteProviderDocument(String id) {
        providerDocumentRepository.deleteById(id);
    }
}
