package com.IPETM69.EscuelaTecnica.dto;

import com.IPETM69.EscuelaTecnica.entity.ReplacementEntity;
import com.IPETM69.EscuelaTecnica.entity.TimeEntity;
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
public class ScheduleDTO {
    
    private Long id;
    private Long idActivity;
    private Long idClass;
    private List<TimeDTO> times;
    private Long idEmployee;
    private ReplacementDTO replacement;
    private PositionEnum position;
    
}
