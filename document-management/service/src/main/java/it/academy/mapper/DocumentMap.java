package it.academy.mapper;

import it.academy.dto.DocumentDto;
import it.academy.model.Document;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentMap extends PropertyMap<DocumentDto, Document> {

    @Autowired
    private Mapper modelMapper;

    @Override
    protected void configure() {
        map().setDocumentId(source.getDocumentId());
        map().setCreationDate(source.getCreationDate());
        map().setCompletionDate(source.getCompletionDate());
        map().getClientDocument().setClientName(source.getClientName());
        map().getClientDocument().setClientSurname(source.getClientSurname());
        map().getClientDocument().setClientPassportNumber(source.getClientPassportNumber());
        map().getClientDocument().getClientAddress().setCountry(source.getClientCountry());
        map().getClientDocument().getClientAddress().setCity(source.getClientCity());
        map().getClientDocument().getClientAddress().setStreet(source.getClientStreet());
        map().getClientDocument().getClientAddress().setIndex(source.getClientIndex());
        map().getProviderDocument().setProviderName(source.getProviderName());
        map().getProviderDocument().setProviderSurname(source.getProviderSurname());
        map().getProviderDocument().setProviderPassportNumber(source.getProviderPassportNumber());
        map().getProviderDocument().getProviderAddress().setCountry(source.getProviderCountry());
        map().getProviderDocument().getProviderAddress().setCity(source.getProviderCity());
        map().getProviderDocument().getProviderAddress().setStreet(source.getProviderStreet());
        map().getProviderDocument().getProviderAddress().setIndex(source.getProviderIndex());
    }
}
