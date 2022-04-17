package com.IPETM69.EscuelaTecnica.controller;

import com.IPETM69.EscuelaTecnica.dto.ClassDTO;
import com.IPETM69.EscuelaTecnica.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("cursos")
public class ClassController {

    @Autowired
    private ClassService classService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ClassDTO create(@Valid @RequestBody ClassDTO classDTO){
        return classService.create(classDTO);
    }

    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<ClassDTO> getAll() {
        return classService.getAllClasses();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClassDTO findById(@PathVariable Long id) {
        return  classService.findById(id);
        }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        classService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ClassDTO update(@PathVariable Long id, @Valid @RequestBody ClassDTO classDTO){
        return classService.update(id, classDTO);
    }
}
