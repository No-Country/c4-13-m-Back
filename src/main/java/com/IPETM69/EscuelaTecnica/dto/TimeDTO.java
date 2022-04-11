package com.IPETM69.EscuelaTecnica.dto;

import com.IPETM69.EscuelaTecnica.enumeration.DayEnum;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimeDTO {

    private Long id;

    private DayEnum day;

    private String hourIn;

    private String minuteIn;

    private String hourOut;

    private String minuteOut;

}
