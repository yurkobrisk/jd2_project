package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProviderDocumentDto {

    private String providerId;

    private String providerName;

    private String providerSurname;

    private String providerPassportNumber;

    private AddressDto providerAddress;
    
}
