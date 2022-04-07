package com.IPETM69.EscuelaTecnica.service;

import com.IPETM69.EscuelaTecnica.dto.ScheduleDTO;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import java.util.List;
import lombok.NonNull;

public interface ScheduleService {
    
    public ScheduleDTO create(ScheduleDTO schedule);
    public ScheduleDTO update(Long id, ScheduleDTO activity) throws ParamNotFound;
    public void delete(@NonNull Long id) throws ParamNotFound;
    public ScheduleDTO findById(Long id) throws ParamNotFound;  
    public List<ScheduleDTO> findAll();
    
}
