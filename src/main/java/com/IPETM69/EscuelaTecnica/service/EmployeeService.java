package com.IPETM69.EscuelaTecnica.service;

import com.IPETM69.EscuelaTecnica.dto.EmployeeDTO;
import com.IPETM69.EscuelaTecnica.dto.ReplacementDTO;

public interface EmployeeService {
    EmployeeDTO save(EmployeeDTO employeeDTO, ReplacementDTO replacementDTO);

}
