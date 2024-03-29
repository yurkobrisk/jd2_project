package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class DocumentDto {

    @NotBlank(message = "Creation Date is required field")
    private String creationDate;
    @NotBlank(message = "Completion Date is required field")
    private String completionDate;

    private String documentId;

    private String clientId;
    @Size(min = 2, message = "Client name must be min 2 symbols")
    private String clientName;
    @NotBlank(message = "Surname is required field")
    private String clientSurname;
    private String clientPassportNumber;
    private String clientCountry;
    private String clientCity;
    private String clientStreet;
    private String clientIndex;
    private String clientAddressId;

    private String providerId;
    @Size(min = 2, message = "Provider name must be min 2 symbols")
    private String providerName;
    @NotBlank(message = "Surname is required field")
    private String providerSurname;
    private String providerPassportNumber;
    private String providerCountry;
    private String providerCity;
    private String providerStreet;
    private String providerIndex;
    private String providerAddressId;
}
