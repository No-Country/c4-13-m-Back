package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.TimeDTO;
import com.IPETM69.EscuelaTecnica.entity.TimeEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TimeMapper {

    public TimeEntity timeDTO2Entity (TimeDTO dto){

        TimeEntity entity = new TimeEntity();
        entity.setDay(dto.getDay());
        entity.setTimeIn(dto.getTimeIn());
        entity.setTimeOut(dto.getTimeOut());
        return entity;

    }

    public TimeDTO timeEntity2DTO (TimeEntity entity){

        TimeDTO dto = new TimeDTO();
        dto.setId(entity.getId());
        dto.setDay(entity.getDay());
        dto.setTimeIn(entity.getTimeIn());
        dto.setTimeOut(entity.getTimeOut());
        return dto;

    }

    public List<TimeEntity> timeDTOList2EntityList(List<TimeDTO> dtos) {
        List<TimeEntity> timeEntities = new ArrayList<>();
        for (TimeDTO dto : dtos){
            timeEntities.add(timeDTO2Entity(dto));
        }
        return timeEntities;

    }

    public List<TimeDTO> timeEntityList2DTOList(List<TimeEntity> entities) {
        List<TimeDTO> dtos = new ArrayList<>();
        for (TimeEntity entity : entities) {
            dtos.add(timeEntity2DTO(entity));
        }
        return dtos;
    }

    public void timeEntityRefreshValues(TimeEntity entity, TimeDTO dto){

        entity.setDay(dto.getDay());
        entity.setTimeIn(dto.getTimeIn());
        entity.setTimeOut(dto.getTimeOut());

    }
}
