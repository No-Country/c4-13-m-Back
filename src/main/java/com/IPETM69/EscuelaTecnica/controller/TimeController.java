package com.IPETM69.EscuelaTecnica.controller;

import com.IPETM69.EscuelaTecnica.dto.TimeDTO;
import com.IPETM69.EscuelaTecnica.dto.TimePrintDTO;
import com.IPETM69.EscuelaTecnica.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/times")
public class TimeController {

    @Autowired
    private TimeService timeService;

//    @GetMapping("/{id}")
//    public ResponseEntity<TimeDTO> getTimeById(@PathVariable Long id){
//
//        TimeDTO timeDTO = timeService.findTimeById(id);
//        return ResponseEntity.ok().body(timeDTO);
//
//    }

    @PostMapping
    public ResponseEntity<TimePrintDTO> create(@Valid @RequestBody TimeDTO dto){

        TimePrintDTO timeDTO = timeService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(timeDTO);

    }

    @PutMapping("/{id}")
    public ResponseEntity<TimePrintDTO> update(@Valid @PathVariable Long id, @RequestBody TimeDTO dto){

        TimePrintDTO timeDTO = timeService.update(id, dto);
        return ResponseEntity.ok().body(timeDTO);

    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<TimeDTO> delete(@PathVariable Long id){

        timeService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
