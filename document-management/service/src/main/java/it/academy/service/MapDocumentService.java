package it.academy.service;

import it.academy.dto.DocumentDto;
import it.academy.dto.DtoToDocument;
import it.academy.model.Document;
import it.academy.repository.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MapDocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<DocumentDto> getAllDocuments(){
        return ((List<Document>) documentRepository
                .findAll())
                .stream()
                .map(this::convertToDocumentDto)
                .collect(Collectors.toList());
    }

    public Document saveDocument(DtoToDocument dtoToDocument){
        return documentRepository
                .saveAndFlush(convertToDocument(dtoToDocument));
    }

    private DocumentDto convertToDocumentDto(Document document) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        DocumentDto documentDto = modelMapper
                .map(document, DocumentDto.class);
        return documentDto;
    }
//TODO метод сохранения данных из формы в базу

    private Document convertToDocument(DtoToDocument dtoToDocument){
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        Document document = modelMapper
                .map(dtoToDocument, Document.class);
        return document;
    }

}
