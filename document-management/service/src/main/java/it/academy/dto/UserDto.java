package it.academy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class UserDto {

//    @Size(min = 3)
    @NotBlank
    private String userName;
//    @Size(min = 8, message = "Password must be min 8 symbols")
    @NotBlank
    private String password;
    private String enabled;
    private String authorityId;
    @NotNull
    private String authority;
}
