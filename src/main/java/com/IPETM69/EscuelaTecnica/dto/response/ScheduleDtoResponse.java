package com.IPETM69.EscuelaTecnica.dto.response;

import com.IPETM69.EscuelaTecnica.dto.ReplacementDTO;
import com.IPETM69.EscuelaTecnica.enumeration.PositionEnum;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ScheduleDtoResponse {
    
    private Long id;
    private Long idActivity;
    private Long idClass;
    private List<TimePrintDTO> times;
    private Long idEmployee;
    private ReplacementDTO replacement;
    private PositionEnum position;
    
}
