package it.academy.mapper;

import it.academy.dto.DocumentDto;
import it.academy.model.Document;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DocumentMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Document toEntity(DocumentDto dto){
        return Objects.isNull(dto) ? null : modelMapper.map(dto, Document.class);
    }

    public DocumentDto toDto(Document entity){
        return Objects.isNull(entity) ? null : modelMapper.map(entity, DocumentDto.class);
    }
}
