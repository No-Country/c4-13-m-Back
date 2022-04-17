package com.IPETM69.EscuelaTecnica.service;


import com.IPETM69.EscuelaTecnica.dto.ActivityDTO;
import com.IPETM69.EscuelaTecnica.dto.response.FilterDTOResponse;
import com.IPETM69.EscuelaTecnica.exception.ActivityNotFoundException;
import java.util.List;
import lombok.NonNull;

public interface ActivityService {
    
    public ActivityDTO create(ActivityDTO activity);
    public ActivityDTO update(Long id, ActivityDTO activity) throws ActivityNotFoundException;
    public void delete(@NonNull Long id) throws ActivityNotFoundException;
    public ActivityDTO findById(Long id) throws ActivityNotFoundException;  
    public List<ActivityDTO> findAll();

}
