package com.IPETM69.EscuelaTecnica.dto;

import com.IPETM69.EscuelaTecnica.enumeration.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClassDTO {
    private Long id;
    private String grade;
    private String division;
    private ShiftEnum shift;
    private String department;
}
