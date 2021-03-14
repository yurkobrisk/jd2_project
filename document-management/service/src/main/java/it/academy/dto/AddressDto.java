package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class AddressDto implements Serializable {

    private String addresId;

    private String country;

    private String city;

    private String street;

    private String index;

}
