package dev.ben.Homemanager.database;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User {

    @GeneratedValue
    @Id
    Long Id;

    String password;

    String email;

    String firstname;

    String lastname;

    boolean isAdmin;
}
