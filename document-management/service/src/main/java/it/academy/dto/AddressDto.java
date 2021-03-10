package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDto {

    private String addresId;

    private String country;

    private String city;

    private String street;

    private String index;

}
