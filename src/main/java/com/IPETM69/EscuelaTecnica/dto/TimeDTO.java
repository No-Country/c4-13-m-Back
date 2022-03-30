package com.IPETM69.EscuelaTecnica.dto;

import com.IPETM69.EscuelaTecnica.enumeration.DayEnum;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Pattern;

@Getter
@Setter
public class TimeDTO {

    private Long id;

    private DayEnum day;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "El formato de la fecha debe ser yyyy/MM/dd")
    private String timeIn;

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "El formato de la fecha debe ser yyyy/MM/dd")
    private String timeOut;

}
