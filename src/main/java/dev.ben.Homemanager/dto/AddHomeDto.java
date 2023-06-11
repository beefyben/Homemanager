package dev.ben.Homemanager.dto;

import lombok.Data;


        import javax.validation.constraints.NotEmpty;
        import javax.validation.constraints.Size;

@Data
public class AddHomeDto {

    @NotEmpty
    @Size(min = 2, max = 30)
    private String homename;

    @NotEmpty
    @Size(min = 2, max = 30)
    private String homeaddress;

    @NotEmpty
    boolean noanimal;


}
