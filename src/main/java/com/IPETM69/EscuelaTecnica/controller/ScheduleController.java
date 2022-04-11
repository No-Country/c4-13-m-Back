package com.IPETM69.EscuelaTecnica.controller;

import com.IPETM69.EscuelaTecnica.dto.ScheduleDTO;
import com.IPETM69.EscuelaTecnica.service.ScheduleService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("cronograma")
public class ScheduleController {
    
    @Autowired
    private ScheduleService scheduleService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ScheduleDTO create(@Valid @RequestBody ScheduleDTO scheduleDTO){
        return scheduleService.create(scheduleDTO);
    }

    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<ScheduleDTO> findAll() {
        return scheduleService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleDTO findById(@RequestParam Long id) {
        return scheduleService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@RequestParam Long id){
        scheduleService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ScheduleDTO update(@RequestParam Long id, @Valid @RequestBody ScheduleDTO scheduleDTO){
        return scheduleService.update(id, scheduleDTO);
    }
    
}
