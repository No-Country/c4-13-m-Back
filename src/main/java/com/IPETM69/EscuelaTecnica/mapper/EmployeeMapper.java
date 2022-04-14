package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.EmployeeDTO;
import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class EmployeeMapper {

    @Autowired
    ScheduleMapper scheduleMapper;

    public EmployeeEntity employeeDTO2Entity (EmployeeDTO employeeDTO){
        EmployeeEntity entity = new EmployeeEntity();

        entity.setFirstName(employeeDTO.getFirstName());
        entity.setLastName(employeeDTO.getLastName());
        entity.setDni(employeeDTO.getDni());
        entity.setPhone(employeeDTO.getPhone());
        entity.setEmail(employeeDTO.getEmail());
        entity.setFile(employeeDTO.getFile());
        return entity;
    }

    public EmployeeDTO employeeEntity2DTO (EmployeeEntity entity){
        EmployeeDTO dto = new EmployeeDTO();

        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setDni(entity.getDni());
        dto.setPhone(entity.getPhone());
        dto.setEmail(entity.getEmail());
        dto.setFile(entity.getFile());
        dto.setSchedules(scheduleMapper.scheduleEntityList2DTOList(entity.getSchedules()));

        return dto;
    }

    public List<EmployeeDTO> employeeEntityList2DTOList(List<EmployeeEntity> entities) {
        List<EmployeeDTO> dtos = new ArrayList<>();
        for (EmployeeEntity entity : entities) {
            dtos.add(employeeEntity2DTO(entity));
        }
        return dtos;
    }

    public void employeeEntityRefreshValues(EmployeeEntity employeeEntity, EmployeeDTO employeeDTO) {
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setDni(employeeDTO.getDni());
        employeeEntity.setPhone(employeeDTO.getPhone());
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setFile(employeeDTO.getFile());
    }


}
