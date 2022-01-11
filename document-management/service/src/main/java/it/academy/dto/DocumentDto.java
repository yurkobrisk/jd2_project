package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class DocumentDto {

    private String creationDate;
    private String completionDate;

    private String documentId;
    @Size(min = 2, message = "Client name must be min 2 symbols")
    private String clientName;
    @NotBlank(message = "Surname is required field")
    private String clientSurname;
    private String clientPassportNumber;
    private String clientCountry;
    private String clientCity;
    private String clientStreet;
    private String clientIndex;

    @Size(min = 2, message = "Provider name must be min 2 symbols")
    private String providerName;
    @NotBlank(message = "Surname is required field")
    private String providerSurname;
    private String providerPassportNumber;
    private String providerCountry;
    private String providerCity;
    private String providerStreet;
    private String providerIndex;
}
