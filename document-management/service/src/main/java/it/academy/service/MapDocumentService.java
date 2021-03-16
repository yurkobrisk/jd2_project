package it.academy.service;

import it.academy.dto.DocumentDto;
import it.academy.mapper.DocumentMap;
import it.academy.mapper.Mapper;
import it.academy.model.Document;
import it.academy.repository.DocumentRepository;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MapDocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private Mapper modelMapper;

    @Autowired
    private DocumentMap documentMap;

    public List<DocumentDto> getAllDocuments(){
        return ((List<Document>) documentRepository
                .findAll())
                .stream()
                .map(this::convertDocumentToDto)
                .collect(Collectors.toList());
    }

    public Document saveDocument(DocumentDto documentDto){
        return documentRepository
                .saveAndFlush(convertDtoToDocument(documentDto));
    }

    public DocumentDto getDocument(String id) {
        return convertDocumentToDto(documentRepository.getOne(id));
    }

    public void deleteDocument(String id) {
        documentRepository.deleteById(id);
    }

    private DocumentDto convertDocumentToDto(Document document) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        DocumentDto documentDto = modelMapper
                .map(document, DocumentDto.class);
        return documentDto;
    }

    private Document convertDtoToDocument(DocumentDto documentDto){
//        modelMapper = new Mapper();
        TypeMap<DocumentDto, Document> typeMap =
                modelMapper.getTypeMap(DocumentDto.class, Document.class);
        if (typeMap == null) {
            modelMapper.addMappings(documentMap);
        }
        return modelMapper.map(documentDto, Document.class);
    }

    public Page<DocumentDto> findAll(Pageable pageable){
        return mapDocumentsPage(documentRepository.findAll(pageable));
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

//    public Page<DocumentDto> findAll(Pageable pageable) {
//        return ((Page<Document>) documentRepository
//                .findAll(pageable))
//                .stream()
//                .map(this::convertDocumentToDto)
//                .;
//    }
}
