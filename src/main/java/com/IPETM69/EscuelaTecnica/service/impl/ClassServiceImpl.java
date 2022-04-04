package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.dto.ClassDTO;
import com.IPETM69.EscuelaTecnica.entity.ClassEntity;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import com.IPETM69.EscuelaTecnica.mapper.ClassMapper;
import com.IPETM69.EscuelaTecnica.repository.ClassRepository;
import com.IPETM69.EscuelaTecnica.service.ClassService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassMapper classMapper;
    @Autowired
    private ClassRepository classRepository;

    public ClassDTO create(ClassDTO dto) {
        ClassEntity entity = classMapper.classDTO2Entity(dto);
        ClassEntity entitySaved = classRepository.save(entity);
        return classMapper.classEntity2DTO(entitySaved);
    }

    public void delete(@NonNull Long id) { classRepository.deleteById(id);}

    public ClassDTO update(Long id, ClassDTO classDTO) {
        Optional<ClassEntity> entity = classRepository.findById(id);
        if (!entity.isPresent()) {
           throw new ParamNotFound("Error: Invalid class id");
        }
        classMapper.classEntityRefreshValues(entity.get(), classDTO);
        ClassEntity entitySaved = classRepository.save(entity.get());
        return classMapper.classEntity2DTO(entitySaved);
    }

    public List<ClassDTO> getAllClasses() {
        List<ClassEntity> entities = classRepository.findAll();
        return classMapper.classEntityList2DTOList(entities);
    }

    public ClassDTO findById(@NonNull Long id) {
        Optional<ClassEntity> entity = classRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Invalid class id");
        }
        return classMapper.classEntity2DTO(entity.get());

    }
}
