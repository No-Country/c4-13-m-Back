package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.ClassDTO;
import com.IPETM69.EscuelaTecnica.entity.ClassEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassMapper {

    public ClassEntity classDTO2Entity(ClassDTO dto) {
        ClassEntity classEntity = new ClassEntity();
        classEntity.setGrade(dto.getGrade());
        classEntity.setDivision(dto.getDivision());
        classEntity.setShift(dto.getShift());
        classEntity.setDepartment(dto.getDepartment());
        return classEntity;
    }

    public ClassDTO classEntity2DTO(ClassEntity entitySaved) {
        ClassDTO classDTO = new ClassDTO();
        classDTO.setId(entitySaved.getId());
        classDTO.setGrade(entitySaved.getGrade());
        classDTO.setDivision(entitySaved.getDivision());
        classDTO.setShift(entitySaved.getShift());
        classDTO.setDepartment(entitySaved.getDepartment());
        return  classDTO;
    }

    public void classEntityRefreshValues(ClassEntity classEntity, ClassDTO classDTO) {
        classEntity.setGrade(classDTO.getGrade());
        classEntity.setDivision(classDTO.getDivision());
        classEntity.setShift(classDTO.getShift());
        classEntity.setDepartment(classDTO.getDepartment());
    }

    public List<ClassDTO> classEntityList2DTOList(List<ClassEntity> entities) {
        List<ClassDTO> dtos = new ArrayList<>();
        for (ClassEntity entity : entities) {
            dtos.add(classEntity2DTO(entity));
        }
        return dtos;
    }
}
