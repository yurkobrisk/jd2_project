package it.academy.service;

import it.academy.dto.DocumentDto;
import it.academy.mapper.DocumentMap;
import it.academy.mapper.Mapper;
import it.academy.model.Document;
import it.academy.repository.DocumentRepository;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MapDocumentService {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private Mapper modelMapper;

    @Autowired
    private DocumentMap documentMap;

    public List<DocumentDto> getAllDocuments(){
        return (documentService
                .readAllDocuments())
                .stream()
                .map(this::convertDocumentToDto)
                .collect(Collectors.toList());
    }

    public Document saveDocument(DocumentDto documentDto){
        return documentService
                .saveDocument(convertDtoToDocument(documentDto));
    }

    public DocumentDto getDocument(String id) {
        return convertDocumentToDto(documentService.readDocument(id));
    }

    public void deleteDocument(String id) {
        documentService.deleteDocument(id);
    }

    private DocumentDto convertDocumentToDto(Document document) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        DocumentDto documentDto = modelMapper
                .map(document, DocumentDto.class);
        return documentDto;
    }

    private Document convertDtoToDocument(DocumentDto documentDto){
        TypeMap<DocumentDto, Document> typeMap =
                modelMapper.getTypeMap(DocumentDto.class, Document.class);
        if (typeMap == null) {
            modelMapper.addMappings(documentMap);
        }
        return modelMapper.map(documentDto, Document.class);
    }

    public Page<DocumentDto> findAll(Integer page, Integer size, String direction, String orderBy){

        List<Document> documentList = null;
        switch (orderBy) {
            case "Creation Date":
                orderBy = "creationDate";
                break;
            case "Client Surname  A-Z":
                orderBy = "client.surname";
                direction = "ASC";
                break;
            case "Client Surname  Z-A":
                orderBy = "client.surname";
                direction = "DESC";
                break;
            case "Provider Surname  A-Z":
                orderBy = "provider.surname";
                direction = "ASC";
                break;
            case "Provider Surname  Z-A":
                orderBy = "provider.surname";
                direction = "DESC";
                break;
            default:
                orderBy = "completionDate";
                break;
        }

        PageRequest pageRequest =
                PageRequest.of(page, size, Sort.Direction.valueOf(direction), orderBy);

        return mapDocumentsPage(documentService.readAllDocuments(pageRequest));
    }

    private List<DocumentDto> mapDocuments(Collection<Document> documents){
        if (documents == null) {
            return null;
        }
        return documents.stream()
                .map(this::convertDocumentToDto)
                .collect(Collectors.toList());
    }

    private Page<DocumentDto> mapDocumentsPage(Page<Document> documents){
        if (documents == null) {
            return null;
        }
        return documents.map(this::convertDocumentToDto);
    }

    private List<Document> mapDtos(Collection<DocumentDto> documentDtos){
        if (documentDtos == null) {
            return null;
        }
        return documentDtos.stream()
                .map(this::convertDtoToDocument)
                .collect(Collectors.toList());
    }

    private Page<Document> mapDtosPage(Page<DocumentDto> documentDtos){
        if (documentDtos == null) {
            return null;
        }
        return documentDtos.map(this::convertDtoToDocument);
    }
}
