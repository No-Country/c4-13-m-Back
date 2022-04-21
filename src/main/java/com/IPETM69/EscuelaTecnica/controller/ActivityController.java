package com.IPETM69.EscuelaTecnica.controller;

import com.IPETM69.EscuelaTecnica.dto.ActivityDTO;
import com.IPETM69.EscuelaTecnica.service.ActivityService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin("*")
@RestController
@RequestMapping("actividad")
public class ActivityController {
    
    @Autowired
    private ActivityService activityService;
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ActivityDTO create(@Valid @RequestBody ActivityDTO activityDTO){
        return activityService.create(activityDTO);
    }

    @GetMapping("/lista")
    @ResponseStatus(HttpStatus.OK)
    public List<ActivityDTO> findAll() {
        return activityService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActivityDTO findById(@PathVariable Long id) {
        return  activityService.findById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        activityService.delete(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ActivityDTO update(@PathVariable Long id, @Valid @RequestBody ActivityDTO activityDTO){
        return activityService.update(id, activityDTO);
    }

}
