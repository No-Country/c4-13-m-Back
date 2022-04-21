package com.IPETM69.EscuelaTecnica.dto.response;

import com.IPETM69.EscuelaTecnica.dto.ReplacementDTO;
import com.IPETM69.EscuelaTecnica.enumeration.PositionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleBasicDtoResponse {
    
    private Long id;
    private String activity;
    private String grade;
    private PositionEnum position;
    
}
