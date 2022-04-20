package com.IPETM69.EscuelaTecnica.service;

import com.IPETM69.EscuelaTecnica.dto.request.EmployeeDTORequest;
import com.IPETM69.EscuelaTecnica.dto.response.EmployeeDTOResponse;
import com.IPETM69.EscuelaTecnica.dto.response.EmployeeBasicDTO;
import lombok.NonNull;
import javax.validation.constraints.NotNull;
import java.util.List;



public interface EmployeeService {
    EmployeeDTOResponse save(EmployeeDTORequest employeeDTO);

    List<EmployeeDTOResponse> getAllEmployees();

    EmployeeDTOResponse findById(@NotNull Long id);

    EmployeeDTOResponse update(Long id, EmployeeDTOResponse employeeDTO);

    void delete(@NonNull Long id);
    
    List<EmployeeBasicDTO> findByName(String name);

}
