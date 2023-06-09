package dev.ben.Homemanager.dto;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class AuthRegisterDto {

    @NotEmpty
    @Size(min = 2, max = 30)
    private String firstname;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String lastname;
    @Email
    private String email;

    @NotEmpty
    @Size(min = 5, max = 30)
    private String password;

}