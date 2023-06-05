package dev.ben.Homemanager.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UserView {

    Long id;

    String email;

    String username;

    boolean isAdmin;
}
