package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.ScheduleDTO;
import com.IPETM69.EscuelaTecnica.entity.ScheduleEntity;
import java.util.ArrayList;
import java.util.List;


public class ScheduleMapper {
        
    public ScheduleEntity scheduleDTO2Entity(ScheduleDTO scheduleDTO) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setIdActivity(scheduleDTO.getIdActivity());
        scheduleEntity.setIdClass(scheduleDTO.getIdClass());
        scheduleEntity.setTimes(scheduleDTO.getTimes());
        scheduleEntity.setIdEmployee(scheduleDTO.getIdEmployee());
        scheduleEntity.setReplacement(scheduleDTO.getReplacement());
        scheduleEntity.setPosition(scheduleDTO.getPosition());
        return scheduleEntity;
    }

    public ScheduleDTO scheduleEntity2DTO(ScheduleEntity scheduleSaved) {
        ScheduleDTO scheduleDTO = new ScheduleDTO();
        scheduleDTO.setId(scheduleSaved.getId());
        scheduleDTO.setIdActivity(scheduleSaved.getIdActivity());
        scheduleDTO.setIdClass(scheduleSaved.getIdClass());
        scheduleDTO.setTimes(scheduleSaved.getTimes());
        scheduleDTO.setIdEmployee(scheduleSaved.getIdEmployee());
        scheduleDTO.setReplacement(scheduleSaved.getReplacement());
        scheduleDTO.setPosition(scheduleSaved.getPosition());
        return scheduleDTO;
    }

    public void scheduleEntityRefreshValues(ScheduleEntity scheduleEntity, ScheduleDTO scheduleDTO) {
        scheduleEntity.setIdActivity(scheduleDTO.getIdActivity());
        scheduleEntity.setIdClass(scheduleDTO.getIdClass());
        scheduleEntity.setTimes(scheduleDTO.getTimes());
        scheduleEntity.setIdEmployee(scheduleDTO.getIdEmployee());
        scheduleEntity.setReplacement(scheduleDTO.getReplacement());
        scheduleEntity.setPosition(scheduleDTO.getPosition());
    }

    public List<ScheduleDTO> scheduleEntityList2DTOList(List<ScheduleEntity> entities) {
        List<ScheduleDTO> dtos = new ArrayList<>();
        for (ScheduleEntity entity : entities) {
            dtos.add(scheduleEntity2DTO(entity));
        }
        return dtos;
    }
    
}
