package com.IPETM69.EscuelaTecnica.service;

import com.IPETM69.EscuelaTecnica.dto.request.ScheduleDtoRequest;
import com.IPETM69.EscuelaTecnica.dto.response.FilterDTOResponse;
import com.IPETM69.EscuelaTecnica.dto.response.ScheduleDtoResponse;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import java.util.List;
import lombok.NonNull;

public interface ScheduleService {
    
    public ScheduleDtoResponse create(ScheduleDtoRequest schedule);
    public ScheduleDtoResponse update(Long id, ScheduleDtoRequest schedule) throws ParamNotFound;
    public void delete(@NonNull Long id) throws ParamNotFound;
    public ScheduleDtoResponse findById(Long id) throws ParamNotFound;
    public List<ScheduleDtoResponse> findAll();
    List<FilterDTOResponse> getByFilter(String activity, List<String> grade, String department);
    
}
