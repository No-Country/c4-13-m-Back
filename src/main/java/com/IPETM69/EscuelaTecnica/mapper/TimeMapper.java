package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.TimeDTO;
import com.IPETM69.EscuelaTecnica.entity.TimeEntity;
import org.springframework.stereotype.Component;

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
        dto.setDay(entity.getDay());
        dto.setTimeIn(entity.getTimeIn());
        dto.setTimeOut(entity.getTimeOut());
        return dto;

    }

    public void timeEntityRefreshValues(TimeEntity entity, TimeDTO dto){

        entity.setDay(dto.getDay());
        entity.setTimeIn(dto.getTimeIn());
        entity.setTimeOut(dto.getTimeOut());

    }
}
