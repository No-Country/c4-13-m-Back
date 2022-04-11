package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.TimeDTO;
import com.IPETM69.EscuelaTecnica.entity.TimeEntity;
import org.springframework.stereotype.Component;

@Component
public class TimeMapper {

    public TimeEntity timeDTO2Entity (TimeDTO dto){

        TimeEntity entity = new TimeEntity();
        entity.setDay(dto.getDay());
        entity.setHourIn(dto.getHourIn());
        entity.setMinuteIn(dto.getMinuteIn());
        entity.setHourOut(dto.getHourOut());
        entity.setMinuteOut(dto.getMinuteOut());
        return entity;

    }

    public TimeDTO timeEntity2DTO (TimeEntity entity){

        TimeDTO dto = new TimeDTO();
        dto.setId(entity.getId());
        dto.setDay(entity.getDay());
        dto.setHourIn(entity.getHourIn());
        dto.setMinuteIn(entity.getMinuteIn());
        dto.setHourOut(entity.getHourOut());
        dto.setMinuteOut(entity.getMinuteOut());
        return dto;

    }

    public void timeEntityRefreshValues(TimeEntity entity, TimeDTO dto){

        entity.setDay(dto.getDay());
        entity.setHourIn(dto.getHourIn());
        entity.setMinuteIn(dto.getMinuteIn());
        entity.setHourOut(dto.getHourOut());
        entity.setMinuteOut(dto.getMinuteOut());

    }
}
