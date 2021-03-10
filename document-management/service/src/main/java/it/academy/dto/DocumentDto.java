package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentDto {

    private String documentId;

    private String clientSurname;

    private String providerSurname;

    private String creationDate;

    private String completionDate;

}
