package dev.ben.Homemanager.database;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Home {

    @GeneratedValue
    @Id
    Long Id;

    String homename;

    String homeaddress;

    String homefirstdate;

    String homelastdate;


    boolean noanimal;

    boolean noparty;

    boolean waterplant;

    boolean feedanimal;

    boolean nosound;


    @ManyToOne
    User creator;
}
