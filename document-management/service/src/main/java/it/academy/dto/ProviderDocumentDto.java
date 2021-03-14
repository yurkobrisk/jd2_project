package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ProviderDocumentDto {

    private String providerId;

    private String providerName;

    private String providerSurname;

    private String providerPassportNumber;

    private AddressDto providerAddress;

    private List<DocumentDto> providerDocuments;
    
}
