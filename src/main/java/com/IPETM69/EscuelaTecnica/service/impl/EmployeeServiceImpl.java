package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.dto.EmployeeDTO;
import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import com.IPETM69.EscuelaTecnica.mapper.EmployeeMapper;
import com.IPETM69.EscuelaTecnica.repository.EmployeeRepository;
import com.IPETM69.EscuelaTecnica.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeDTO save(EmployeeDTO dto){
        //convertir dto a entity
        EmployeeEntity entity = employeeMapper.employeeDTO2Entity(dto);
        //guardamos la entidad en la BBDD
        EmployeeEntity entitySaved = employeeRepository.save(entity);
        //volvemos a convertir de entity a DTO
        EmployeeDTO result = employeeMapper.employeeEntity2DTO(entitySaved);
        return result;
    }

}
