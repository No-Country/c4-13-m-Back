package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.TimeDTO;
import com.IPETM69.EscuelaTecnica.entity.TimeEntity;
import com.IPETM69.EscuelaTecnica.util.StringCustomUtil;
import org.springframework.stereotype.Component;

@Component
public class TimeMapper {

    public TimeEntity timeDTO2Entity (TimeDTO dto){

        TimeEntity entity = new TimeEntity();
        entity.setDay(dto.getDay());
        entity.setTimeIn(StringCustomUtil.string2LocalDate(dto.getTimeIn()));
        entity.setTimeOut(StringCustomUtil.string2LocalDate(dto.getTimeOut()));
        return entity;

    }

    public TimeDTO timeEntity2DTO (TimeEntity entity){

        TimeDTO dto = new TimeDTO();
        dto.setId(entity.getId());
        dto.setDay(entity.getDay());
        dto.setTimeIn(entity.getTimeIn().toString());
        dto.setTimeOut(entity.getTimeOut().toString());
        return dto;

    }

    public void timeEntityRefreshValues(TimeEntity entity, TimeDTO dto){

        entity.setDay(dto.getDay());
        entity.setTimeIn(StringCustomUtil.string2LocalDate(dto.getTimeIn()));
        entity.setTimeOut(StringCustomUtil.string2LocalDate(dto.getTimeOut()));

    }
}
