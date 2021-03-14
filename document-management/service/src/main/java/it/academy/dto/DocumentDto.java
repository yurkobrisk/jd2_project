package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DocumentDto {

    private String creationDate;
    private String completionDate;

    private String documentId;

    private String clientName;
    private String clientSurname;
    private String clientPassportNumber;
    private String clientCountry;
    private String clientCity;
    private String clientStreet;
    private String clientIndex;

    private String providerName;
    private String providerSurname;
    private String providerPassportNumber;
    private String providerCountry;
    private String providerCity;
    private String providerStreet;
    private String providerIndex;
}
