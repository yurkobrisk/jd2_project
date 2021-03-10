package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDocumentDto {

    private String clientId;

    private String clientName;

    private String clientSurname;

    private String clientPassportNumber;

    private AddressDto clientAddress;

}
