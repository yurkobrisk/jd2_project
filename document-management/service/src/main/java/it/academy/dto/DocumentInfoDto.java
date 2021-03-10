package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentInfoDto {

    String creationDate;

    String completionDate;

    String clientSurname;

    String providerSurname;

}
