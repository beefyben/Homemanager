package dev.ben.Homemanager.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class HomeView {

    Long Id;

    String homename;

    String homeaddress;

    boolean nodogs;

    boolean noparty;

}

