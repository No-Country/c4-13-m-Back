package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.ReplacementDTO;
import com.IPETM69.EscuelaTecnica.entity.ReplacementEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class ReplacementMapper {

    public ReplacementEntity replacementDTO2Entity (ReplacementDTO dto){
        ReplacementEntity entity = new ReplacementEntity();

        entity.setCheckIn(string2LocalDate(dto.getCheckIn()));
        entity.setCheckOut(string2LocalDate(dto.getCheckOut()));

        return entity;
    }

    public ReplacementDTO replacementEntity2DTO (ReplacementEntity entity){
        ReplacementDTO dto = new ReplacementDTO();

        dto.setId(entity.getId());
        dto.setCheckIn(entity.getCheckIn().toString());
        dto.setCheckOut(entity.getCheckOut().toString());

        return dto;
    }

    private LocalDate string2LocalDate(String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(stringDate, formatter);
        return date;
    }
}
