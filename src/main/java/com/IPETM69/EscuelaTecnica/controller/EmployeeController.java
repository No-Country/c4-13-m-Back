package com.IPETM69.EscuelaTecnica.controller;

import com.IPETM69.EscuelaTecnica.dto.request.EmployeeDTORequest;
import com.IPETM69.EscuelaTecnica.dto.response.EmployeeDTOResponse;
import com.IPETM69.EscuelaTecnica.dto.response.EmployeeBasicDTO;
import com.IPETM69.EscuelaTecnica.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("personal")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<EmployeeDTOResponse> save(@RequestBody EmployeeDTORequest employee){
        EmployeeDTOResponse savedEmployee = employeeService.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEmployee);
    }

    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeDTOResponse> getAll(){
        return employeeService.getAllEmployees();
    }
    
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeBasicDTO> getByName(@RequestParam(required = false) String name){
        return employeeService.findByName(name);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTOResponse findById(@PathVariable Long id) {
        return  employeeService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeDTOResponse update(@PathVariable Long id, @Valid @RequestBody EmployeeDTOResponse employeeDTO){
        return employeeService.update(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        employeeService.delete(id);
    }

}
