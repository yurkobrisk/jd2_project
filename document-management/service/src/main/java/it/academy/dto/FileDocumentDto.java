package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@Data
@NoArgsConstructor
public class FileDocumentDto {

    private String fileId;

    private File file;

}
