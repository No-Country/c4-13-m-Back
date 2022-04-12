package com.IPETM69.EscuelaTecnica.dto;

import com.IPETM69.EscuelaTecnica.enumeration.DayEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimePrintDTO {

    private Long id;

    private DayEnum day;

    private String timeIn;

    private String timeOut;

}
