package com.IPETM69.EscuelaTecnica.service;

import com.IPETM69.EscuelaTecnica.dto.EmployeeDTO;
import lombok.NonNull;
import javax.validation.constraints.NotNull;
import java.util.List;



public interface EmployeeService {
    EmployeeDTO save(EmployeeDTO employeeDTO);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO findById(@NotNull Long id);

    EmployeeDTO update(Long id, EmployeeDTO employeeDTO);

    void delete(@NonNull Long id);
    
    List<EmployeeDTO> findByName(String name);

//    List<EmployeeDTO> getByFilters(String firstName, String lastName);

}
