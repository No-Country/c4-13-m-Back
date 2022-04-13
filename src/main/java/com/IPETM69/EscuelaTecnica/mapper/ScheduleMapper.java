package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.request.ScheduleDtoRequest;
import com.IPETM69.EscuelaTecnica.dto.response.ScheduleDtoResponse;
import com.IPETM69.EscuelaTecnica.entity.ScheduleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScheduleMapper {

    @Autowired
    TimeMapper timeMapper;

    @Autowired
    ReplacementMapper replacementMapper;

    public ScheduleEntity scheduleRequestDTO2Entity(ScheduleDtoRequest scheduleDtoRequest) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setIdActivity(scheduleDtoRequest.getIdActivity());
        scheduleEntity.setIdClass(scheduleDtoRequest.getIdClass());
        scheduleEntity.setTimes(timeMapper.timeDTOList2EntityList(scheduleDtoRequest.getTimes()));
        scheduleEntity.setIdEmployee(scheduleDtoRequest.getIdEmployee());
        scheduleEntity.setPosition(scheduleDtoRequest.getPosition());
        if(scheduleDtoRequest.getReplacement() !=null){
            scheduleEntity.setReplacement(replacementMapper.replacementDTO2Entity(scheduleDtoRequest.getReplacement()));
        }

        return scheduleEntity;
    }

    public ScheduleDtoResponse scheduleEntity2DTO(ScheduleEntity scheduleSaved) {
        ScheduleDtoResponse scheduleDtoResponse = new ScheduleDtoResponse();
        scheduleDtoResponse.setId(scheduleSaved.getId());
        scheduleDtoResponse.setIdActivity(scheduleSaved.getIdActivity());
        scheduleDtoResponse.setIdClass(scheduleSaved.getIdClass());
        scheduleDtoResponse.setTimes(timeMapper.timeEntityList2DTOList(scheduleSaved.getTimes()));
        scheduleDtoResponse.setIdEmployee(scheduleSaved.getIdEmployee());
        scheduleDtoResponse.setPosition(scheduleSaved.getPosition());
        if (scheduleSaved.getReplacement() != null){
            scheduleDtoResponse.setReplacement(replacementMapper.replacementEntity2DTO(scheduleSaved.getReplacement()));
        }
        return scheduleDtoResponse;
    }

    public void scheduleEntityRefreshValues(ScheduleEntity scheduleEntity, ScheduleDtoRequest scheduleDtoRequest) {
        scheduleEntity.setIdActivity(scheduleDtoRequest.getIdActivity());
        scheduleEntity.setIdClass(scheduleDtoRequest.getIdClass());
        scheduleEntity.setTimes(timeMapper.timeDTOList2EntityList(scheduleDtoRequest.getTimes()));
        scheduleEntity.setIdEmployee(scheduleDtoRequest.getIdEmployee());
        scheduleEntity.setPosition(scheduleDtoRequest.getPosition());
        if (scheduleDtoRequest.getReplacement() != null){
            scheduleEntity.setReplacement(replacementMapper.replacementDTO2Entity(scheduleDtoRequest.getReplacement()));
        }
    }

    public List<ScheduleDtoResponse> scheduleEntityList2DTOList(List<ScheduleEntity> entities) {
        List<ScheduleDtoResponse> dtos = new ArrayList<>();
        for (ScheduleEntity entity : entities) {
            dtos.add(scheduleEntity2DTO(entity));
        }
        return dtos;
    }

}
