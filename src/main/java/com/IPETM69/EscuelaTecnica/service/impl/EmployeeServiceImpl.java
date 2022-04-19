package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.dto.request.EmployeeDTORequest;
import com.IPETM69.EscuelaTecnica.dto.response.EmployeeDTOResponse;
import com.IPETM69.EscuelaTecnica.dto.response.EmployeeFilterDTO;
import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import com.IPETM69.EscuelaTecnica.mapper.EmployeeMapper;
import com.IPETM69.EscuelaTecnica.repository.EmployeeRepository;
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

    public EmployeeDTOResponse save(EmployeeDTORequest employeeDTO){
        EmployeeEntity entity = employeeMapper.employeeDTORequest2Entity(employeeDTO);
        EmployeeEntity entitySaved = employeeRepository.save(entity);
        EmployeeDTOResponse result = employeeMapper.employeeEntity2DTO(entitySaved);
        return result;
    }

    public List<EmployeeDTOResponse> getAllEmployees(){
        List<EmployeeEntity> entities = employeeRepository.findAll();
        return employeeMapper.employeeEntityList2DTOList(entities);
    }

    public EmployeeDTOResponse findById(@NotNull Long id) {
        Optional<EmployeeEntity> entity = employeeRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Error: Invalid employee id");
        }
        return employeeMapper.employeeEntity2DTO(entity.get());
    }

    public EmployeeDTOResponse update(Long id, EmployeeDTOResponse employeeDTO) {
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
    
    @Override
    public List<EmployeeFilterDTO> findByName(String name){
        List<EmployeeEntity> entities = employeeRepository.findByName("%"+name.toLowerCase()+"%");
        return employeeMapper.employeeEntityList2DTOFilterList(entities);
    }
   

}
