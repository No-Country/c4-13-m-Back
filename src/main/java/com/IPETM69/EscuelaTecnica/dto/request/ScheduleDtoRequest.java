package com.IPETM69.EscuelaTecnica.dto.request;

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
public class ScheduleDtoRequest {
    
    private Long id;
    private Long idActivity;
    private Long idClass;
    private List<TimeDTO> times;
    private Long idEmployee;
    private ReplacementDTO replacement;
    private PositionEnum position;
    
}
