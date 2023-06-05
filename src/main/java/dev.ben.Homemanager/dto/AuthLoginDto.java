package dev.ben.Homemanager.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class AuthLoginDto {

    String email;
    String password;
}
