package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.EmployeeDTO;
import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {

    public EmployeeEntity employeeDTO2Entity (EmployeeDTO dto){
        EmployeeEntity entity = new EmployeeEntity();

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setDni(dto.getDni());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setFile(dto.getFile());
        entity.setActivities(dto.getActivities());
        entity.setEsTitular(dto.getEsTitular());

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
