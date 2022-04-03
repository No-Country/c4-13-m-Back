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
    /*
    si llegamos a eliminar el replacemententity tengo q modificar este mapper y volver a ponerlo en employee
     */
    public ReplacementEntity employeeDTO2Entity (EmployeeDTO employeeDTO, ReplacementDTO replacementDTO){
        ReplacementEntity replacement = new ReplacementEntity();

        replacement.setFirstName(employeeDTO.getFirstName());
        replacement.setLastName(employeeDTO.getLastName());
        replacement.setDni(employeeDTO.getDni());
        replacement.setPhone(employeeDTO.getPhone());
        replacement.setEmail(employeeDTO.getEmail());
        replacement.setFile(employeeDTO.getFile());
        replacement.setActivities(employeeDTO.getActivities());
        replacement.setEsTitular(employeeDTO.getEsTitular());

        if (employeeDTO.getEsTitular()){
            replacement.setName(PositionEnum.valueOf(replacementDTO.getName()));
            replacement.setCheckIn(LocalDate.parse(replacementDTO.getCheckIn()));
            replacement.setCheckOut(LocalDate.parse(replacementDTO.getCheckOut()));
            //replacement.setReplaceWho(); // como hago para convertir un string en un employee entity
        }

        return replacement;
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
