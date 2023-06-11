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
public class Homes {

    @GeneratedValue
    @Id
    Long Id;

    String homename;

    String homeaddress;

    String homefirstdate;

    /**
    omename!: string;
    homeaddress!: string;
    homefirstdate!: string;
    homelastdate!: string;
    noanimal!: boolean;
    noparty!:boolean;
    nosound!:boolean;
    waterplant!:boolean;
    feedanimal!:boolean;
     **/

    boolean noanimal;

    boolean noparty;

    @ManyToOne
    User creator;
}
