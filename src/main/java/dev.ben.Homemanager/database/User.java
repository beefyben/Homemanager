package dev.ben.Homemanager.database;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {

    @GeneratedValue
    @Id
    Long id;

    String email;

    String username;

    String password;

    boolean isAdmin;
}
