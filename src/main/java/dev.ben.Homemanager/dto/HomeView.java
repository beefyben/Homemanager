package dev.ben.Homemanager.dto;

import dev.ben.Homemanager.database.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.ManyToOne;

@Data
@Getter
@Setter
public class HomeView {

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

