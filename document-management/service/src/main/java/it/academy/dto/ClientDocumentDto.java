package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ClientDocumentDto {

    private String clientId;

    private String clientName;

    private String clientSurname;

    private String clientPassportNumber;

    private AddressDto clientAddress;

    private List<DocumentDto> clientDocuments;

}
