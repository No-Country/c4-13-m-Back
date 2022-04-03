package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.EmployeeDTO;
import com.IPETM69.EscuelaTecnica.dto.ReplacementDTO;
import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import com.IPETM69.EscuelaTecnica.entity.ReplacementEntity;
import com.IPETM69.EscuelaTecnica.enumeration.PositionEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class EmployeeMapper {

    public EmployeeEntity employeeDTO2Entity (EmployeeDTO employeeDTO, ReplacementDTO replacementDTO){
        EmployeeEntity entity = new EmployeeEntity();

        entity.setFirstName(employeeDTO.getFirstName());
        entity.setLastName(employeeDTO.getLastName());
        entity.setDni(employeeDTO.getDni());
        entity.setPhone(employeeDTO.getPhone());
        entity.setEmail(employeeDTO.getEmail());
        entity.setFile(employeeDTO.getFile());
        entity.setActivities(employeeDTO.getActivities());
        entity.setEsTitular(employeeDTO.getEsTitular());

        if (employeeDTO.getEsTitular()){
            ReplacementEntity replacement = new ReplacementEntity();
            replacement.setName(PositionEnum.valueOf(replacementDTO.getName()));
            replacement.setCheckIn(LocalDate.parse(replacementDTO.getCheckIn()));
            replacement.setCheckOut(LocalDate.parse(replacementDTO.getCheckOut()));
            //replacement.setReplaceWho(); // como hago para convertir un string en un employee entity
        }

        return entity;
    }

    public EmployeeDTO employeeEntity2DTO (EmployeeEntity entity){
        EmployeeDTO dto = new EmployeeDTO();

        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDni(entity.getDni());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setFile(entity.getFile());
        dto.setActivities(entity.getActivities());
        dto.setEsTitular(entity.getEsTitular());

        return dto;
    }
}
