package dev.ben.Homemanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthLoginView {
    private String token;
    private UserView user;
}