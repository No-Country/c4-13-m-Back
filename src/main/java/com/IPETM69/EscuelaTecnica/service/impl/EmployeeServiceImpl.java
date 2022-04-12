package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.dto.EmployeeDTO;
import com.IPETM69.EscuelaTecnica.dto.EmployeeFilterDTO;
import com.IPETM69.EscuelaTecnica.entity.ActivityEntity;
import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import com.IPETM69.EscuelaTecnica.mapper.EmployeeMapper;
import com.IPETM69.EscuelaTecnica.repository.EmployeeRepository;
import com.IPETM69.EscuelaTecnica.repository.specification.EmployeeSpecification;
import com.IPETM69.EscuelaTecnica.service.EmployeeService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeSpecification employeeSpecification;

    public EmployeeDTO save(EmployeeDTO employeeDTO){
        EmployeeEntity entity = employeeMapper.employeeDTO2Entity(employeeDTO);
        EmployeeEntity entitySaved = employeeRepository.save(entity);
        EmployeeDTO result = employeeMapper.employeeEntity2DTO(entitySaved);
        return result;
    }

    public List<EmployeeDTO> getAllEmployees(){
        List<EmployeeEntity> entities = employeeRepository.findAll();
        return employeeMapper.employeeEntityList2DTOList(entities);
    }

    public EmployeeDTO findById(@NotNull Long id) {
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Invalid employee id");
        }
        return employeeMapper.employeeEntity2DTO(entity.get());
    }

    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Invalid employee id");
        }
        employeeMapper.employeeEntityRefreshValues(entity.get(),employeeDTO);
        EmployeeEntity entitySaved = employeeRepository.save(entity.get());
        return employeeMapper.employeeEntity2DTO(entitySaved);
    }

    public void delete(@NonNull Long id) {
        employeeRepository.deleteById(id);
    }

    public List<EmployeeDTO> getByFilters(String firstName, String lastName){
        EmployeeFilterDTO employeeFilterDTO = new EmployeeFilterDTO(firstName,lastName);
        List<EmployeeEntity> entities = employeeRepository.findAll(employeeSpecification.getByFilters(employeeFilterDTO));
        List<EmployeeDTO> dtos = employeeMapper.employeeEntityList2DTOList(entities);
        return dtos;
    }
    
    @Override
    public List<EmployeeDTO> findByName(String name){
        List<EmployeeEntity> entities = employeeRepository.findByName("%"+name+"%");
        return employeeMapper.employeeEntityList2DTOList(entities);
    }
   

}
