package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
public class UserDto implements Serializable {

    private String userId;

    private String userName;

    private String password;

    private List<DocumentDto> userDocuments;

}
