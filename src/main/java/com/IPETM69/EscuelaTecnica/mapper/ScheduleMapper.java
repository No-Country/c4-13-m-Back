package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.dto.request.ScheduleDtoRequest;
import com.IPETM69.EscuelaTecnica.dto.response.FilterDTOResponse;
import com.IPETM69.EscuelaTecnica.dto.response.ScheduleDtoResponse;
import com.IPETM69.EscuelaTecnica.dto.response.ScheduleSearchDto;
import com.IPETM69.EscuelaTecnica.entity.ScheduleEntity;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import com.IPETM69.EscuelaTecnica.repository.ActivityRepository;
import com.IPETM69.EscuelaTecnica.repository.ClassRepository;
import com.IPETM69.EscuelaTecnica.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class ScheduleMapper {

    @Autowired
    TimeMapper timeMapper;

    @Autowired
    ReplacementMapper replacementMapper;

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    ClassRepository classRepository;

    public ScheduleEntity scheduleRequestDTO2Entity(ScheduleDtoRequest scheduleDtoRequest) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setActivity(activityRepository.findById(scheduleDtoRequest.getIdActivity()).orElseThrow( () -> new ParamNotFound("Activity not found.")));
        scheduleEntity.setClassEntity(classRepository.findById(scheduleDtoRequest.getIdClass()).orElseThrow( () -> new ParamNotFound("Class not found.")));
        scheduleEntity.setTimes(timeMapper.timeDTOList2EntityList(scheduleDtoRequest.getTimes()));
        scheduleEntity.setEmployee(employeeRepository.findById(scheduleDtoRequest.getIdEmployee()).orElseThrow( () -> new ParamNotFound("Employee not found.")));
        scheduleEntity.setPosition(scheduleDtoRequest.getPosition());
        if(scheduleDtoRequest.getReplacement() !=null){
            scheduleEntity.setReplacement(replacementMapper.replacementDTO2Entity(scheduleDtoRequest.getReplacement()));
        }
        return scheduleEntity;
    }

    public ScheduleEntity scheduleResponseDTO2Entity(ScheduleDtoResponse scheduleDtoResponse) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setActivity(activityRepository.findById(scheduleDtoResponse.getIdActivity()).orElseThrow( () -> new ParamNotFound("Activity not found.")));
        scheduleEntity.setClassEntity(classRepository.findById(scheduleDtoResponse. getIdClass()).orElseThrow( () -> new ParamNotFound("Class not found.")));
        scheduleEntity.setTimes(timeMapper.timePrintDTOList2EntityList(scheduleDtoResponse.getTimes()));
        scheduleEntity.setEmployee(employeeRepository.findById(scheduleDtoResponse. getIdEmployee()).orElseThrow( () -> new ParamNotFound("Employee not found.")));
        scheduleEntity.setPosition(scheduleDtoResponse.getPosition());
        if(scheduleDtoResponse.getReplacement() !=null){
            scheduleEntity.setReplacement(replacementMapper.replacementDTO2Entity(scheduleDtoResponse.getReplacement()));
        }
        return scheduleEntity;
    }

    public ScheduleDtoResponse scheduleEntity2DTO(ScheduleEntity scheduleSaved) {
        ScheduleDtoResponse scheduleDtoResponse = new ScheduleDtoResponse();
        scheduleDtoResponse.setId(scheduleSaved.getId());
        scheduleDtoResponse.setIdActivity(scheduleSaved.getActivity().getId());
        scheduleDtoResponse.setIdClass(scheduleSaved.getClassEntity().getId());
        scheduleDtoResponse.setTimes(timeMapper.timeEntityList2DTOList(scheduleSaved.getTimes()));
        scheduleDtoResponse.setIdEmployee(scheduleSaved.getEmployee().getId());
        scheduleDtoResponse.setPosition(scheduleSaved.getPosition());
        if (scheduleSaved.getReplacement() != null){
            scheduleDtoResponse.setReplacement(replacementMapper.replacementEntity2DTO(scheduleSaved.getReplacement()));
        }
        return scheduleDtoResponse;
    }

    public void scheduleEntityRefreshValues(ScheduleEntity scheduleEntity, ScheduleDtoRequest scheduleDtoRequest) {
        scheduleEntity.setActivity((activityRepository.findById(scheduleDtoRequest.getIdActivity()).orElseThrow( () -> new ParamNotFound("Activity not found."))));
        scheduleEntity.setClassEntity(classRepository.findById(scheduleDtoRequest.getIdClass()).orElseThrow( () -> new ParamNotFound("Class not found.")));
        scheduleEntity.setTimes(timeMapper.timeDTOList2EntityList(scheduleDtoRequest.getTimes()));
        scheduleEntity.setEmployee(employeeRepository.findById(scheduleDtoRequest.getIdEmployee()).orElseThrow( () -> new ParamNotFound("Employee not found.")));
        scheduleEntity.setPosition(scheduleDtoRequest.getPosition());
        if (scheduleDtoRequest.getReplacement() != null){
            scheduleEntity.setReplacement(replacementMapper.replacementDTO2Entity(scheduleDtoRequest.getReplacement()));
        }
    }

    public List<ScheduleDtoResponse> scheduleEntityList2DTOList(List<ScheduleEntity> entities) {
        List<ScheduleDtoResponse> dtos = new ArrayList<>();
        for (ScheduleEntity entity : entities) {
            dtos.add(scheduleEntity2DTO(entity));
        }
        return dtos;
    }

    public List<ScheduleEntity> scheduleDTOList2EntityList(List<ScheduleDtoResponse> dtos) {
        List<ScheduleEntity> entities = new ArrayList<>();
        for (ScheduleDtoResponse dto : dtos) {
            entities.add(scheduleResponseDTO2Entity(dto));
        }
        return entities;
    }

    public List<FilterDTOResponse> filterEntityList2DTOList(List<ScheduleEntity> entities) {
        List<FilterDTOResponse> dtos = new ArrayList<>();
        for (ScheduleEntity entity : entities) {
            dtos.add(filterEntity2DTO(entity));
        }
        return dtos;
    }

    public FilterDTOResponse filterEntity2DTO(ScheduleEntity scheduleSaved) {
        FilterDTOResponse dtoResponse = new FilterDTOResponse();

        dtoResponse.setActivity(scheduleSaved.getActivity().getName());
        dtoResponse.setGrade(scheduleSaved.getClassEntity().getGrade() + scheduleSaved.getClassEntity().getDivision());
        dtoResponse.setDepartment(scheduleSaved.getClassEntity().getDepartment());
        dtoResponse.setEmployee(scheduleSaved.getEmployee().getFirstName() + " " +
                scheduleSaved.getEmployee().getLastName());
        return dtoResponse;
    }

    public ScheduleSearchDto scheduleEntity2ScheduleSearchDto(List<ScheduleEntity> schedules) {
        ScheduleSearchDto searchDto = new ScheduleSearchDto();
        Set<String> activities = new HashSet<>();
        Set<String> grade = new HashSet<>();
        Set<String> department = new HashSet<>();

        for (ScheduleEntity schedule : schedules){
            activities.add(schedule.getActivity().getName());
            grade.add(schedule.getClassEntity().getGrade());
            department.add(schedule.getClassEntity().getDepartment());
        }
        searchDto.setActivity(activities.stream().sorted().collect(Collectors.toList()));
        searchDto.setGrades(grade.stream().sorted().collect(Collectors.toList()));
        searchDto.setDepartment(department.stream().sorted().collect(Collectors.toList()));

        return searchDto;
    }
}
