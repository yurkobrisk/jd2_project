package it.academy.service;

import it.academy.dto.DocumentDto;
import it.academy.dto.DtoToDocument;
import it.academy.mapper.DocumentMap;
import it.academy.mapper.Mapper;
import it.academy.model.Document;
import it.academy.repository.DocumentRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
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

    public Document saveDocument(DtoToDocument dtoToDocument){
        return documentRepository
                .save(convertDtoToDocument(dtoToDocument));
    }

    private DocumentDto convertDocumentToDto(Document document) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        DocumentDto documentDto = modelMapper
                .map(document, DocumentDto.class);
        return documentDto;
    }

    private Document convertDtoToDocument(DtoToDocument dtoToDocument){
//        modelMapper = new Mapper();
        TypeMap<DtoToDocument, Document> typeMap =
                modelMapper.getTypeMap(DtoToDocument.class, Document.class);
        if (typeMap == null) {
            modelMapper.addMappings(documentMap);
        }
        return modelMapper.map(dtoToDocument, Document.class);
    }
}
