package com.IPETM69.EscuelaTecnica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReplacementDTO {

    private Long id;
    private String checkIn;
    private String checkOut;

}
