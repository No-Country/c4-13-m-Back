package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.ActivityDTO;
import com.IPETM69.EscuelaTecnica.entity.ActivityEntity;
import java.util.ArrayList;
import java.util.List;


public class ActivityMapper {
    
     public ActivityEntity activityDTO2Entity(ActivityDTO activityDTO) {
        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName(activityDTO.getName());
        activityEntity.setClasses(activityDTO.getClasses());
        activityEntity.setTimes(activityDTO.getTimes());
        activityEntity.setEsCargo(activityDTO.getEsCargo());
        return activityEntity;
    }

    public ActivityDTO activityEntity2DTO(ActivityEntity activitySaved) {
        ActivityDTO activityDTO = new ActivityDTO();
        activityDTO.setId(activitySaved.getId());
        activityDTO.setName(activitySaved.getName());
        activityDTO.setClasses(activitySaved.getClasses());
        activityDTO.setTimes(activitySaved.getTimes());
        activityDTO.setEsCargo(activitySaved.getEsCargo());
        return  activityDTO;
    }

    public void activityEntityRefreshValues(ActivityEntity activityEntity, ActivityDTO activityDTO) {
        activityEntity.setName(activityDTO.getName());
        activityEntity.setClasses(activityDTO.getClasses());
        activityEntity.setTimes(activityDTO.getTimes());
        activityEntity.setEsCargo(activityDTO.getEsCargo());
    }

    public List<ActivityDTO> activityEntityList2DTOList(List<ActivityEntity> entities) {
        List<ActivityDTO> dtos = new ArrayList<>();
        for (ActivityEntity entity : entities) {
            dtos.add(activityEntity2DTO(entity));
        }
        return dtos;
    }
}
