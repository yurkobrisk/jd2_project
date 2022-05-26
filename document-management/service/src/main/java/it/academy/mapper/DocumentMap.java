package it.academy.mapper;

import it.academy.dto.DocumentDto;
import it.academy.model.Document;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public class DocumentMap extends PropertyMap<DocumentDto, Document> {

    @Override
    protected void configure() {
        map().setDocumentId(source.getDocumentId());
        map().setCreationDate(source.getCreationDate());
        map().setCompletionDate(source.getCompletionDate());
        map().getClient().setName(source.getClientName());
        map().getClient().setSurname(source.getClientSurname());
        map().getClient().setPassportNumber(source.getClientPassportNumber());
        map().getClient().getAddress().setCountry(source.getClientCountry());
        map().getClient().getAddress().setCity(source.getClientCity());
        map().getClient().getAddress().setStreet(source.getClientStreet());
        map().getClient().getAddress().setIndex(source.getClientIndex());
        map().getProvider().setName(source.getProviderName());
        map().getProvider().setSurname(source.getProviderSurname());
        map().getProvider().setPassportNumber(source.getProviderPassportNumber());
        map().getProvider().getAddress().setCountry(source.getProviderCountry());
        map().getProvider().getAddress().setCity(source.getProviderCity());
        map().getProvider().getAddress().setStreet(source.getProviderStreet());
        map().getProvider().getAddress().setIndex(source.getProviderIndex());
    }
}
