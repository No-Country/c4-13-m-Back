package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.dto.EmployeeDTO;
import com.IPETM69.EscuelaTecnica.dto.request.ScheduleDtoRequest;
import com.IPETM69.EscuelaTecnica.dto.response.ScheduleDtoResponse;
import com.IPETM69.EscuelaTecnica.entity.EmployeeEntity;
import com.IPETM69.EscuelaTecnica.entity.ScheduleEntity;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import com.IPETM69.EscuelaTecnica.mapper.EmployeeMapper;
import com.IPETM69.EscuelaTecnica.mapper.ScheduleMapper;
import com.IPETM69.EscuelaTecnica.repository.ScheduleRepository;
import com.IPETM69.EscuelaTecnica.service.EmployeeService;
import com.IPETM69.EscuelaTecnica.service.ScheduleService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;

import com.IPETM69.EscuelaTecnica.service.TimeService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Autowired
    private TimeService timeService;

    @Transactional
    public ScheduleDtoResponse create(ScheduleDtoRequest schedule) {
        ScheduleEntity entity = scheduleMapper.scheduleRequestDTO2Entity(schedule);
        ScheduleEntity entitySaved = scheduleRepository.save(entity);
        return scheduleMapper.scheduleEntity2DTO(entitySaved);
    }

    @Transactional
    public void delete(@NonNull Long id) throws ParamNotFound {
        Optional<ScheduleEntity> opt = scheduleRepository.findById(id);
        if (opt.isPresent()) {
            scheduleRepository.delete(opt.get());
        } else {
            throw new ParamNotFound("Schedule not found");
        }
    }

    @Transactional
    public ScheduleDtoResponse update(@NonNull Long id, ScheduleDtoRequest schedule) {
        Optional<ScheduleEntity> opt = scheduleRepository.findById(id);
        if (opt.isPresent()) {
            scheduleMapper.scheduleEntityRefreshValues(opt.get(), schedule);
            ScheduleEntity scheduleSaved = scheduleRepository.save(opt.get());
            return scheduleMapper.scheduleEntity2DTO(scheduleSaved);
        } else {
            throw new ParamNotFound("Schedule not found");
        }
    }

    public List<ScheduleDtoResponse> findAll() throws ParamNotFound {
        List<ScheduleEntity> entities = scheduleRepository.findAll();
        return scheduleMapper.scheduleEntityList2DTOList(entities);
    }

    public ScheduleDtoResponse findById(@NonNull Long id) {
        Optional<ScheduleEntity> opt = scheduleRepository.findById(id);
        if (opt.isPresent()) {
            return scheduleMapper.scheduleEntity2DTO(opt.get());
        } else {
            throw new ParamNotFound("Schedule not found");
        }
    }
    
}
