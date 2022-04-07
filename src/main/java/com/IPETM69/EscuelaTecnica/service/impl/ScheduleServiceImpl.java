package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.dto.ScheduleDTO;
import com.IPETM69.EscuelaTecnica.entity.ScheduleEntity;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import com.IPETM69.EscuelaTecnica.mapper.ScheduleMapper;
import com.IPETM69.EscuelaTecnica.repository.ScheduleRepository;
import com.IPETM69.EscuelaTecnica.service.ScheduleService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    
    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Override
    @Transactional
    public ScheduleDTO create(ScheduleDTO schedule) {
        ScheduleEntity entity = scheduleMapper.scheduleDTO2Entity(schedule);
        ScheduleEntity entitySaved = scheduleRepository.save(entity);
        return scheduleMapper.scheduleEntity2DTO(entitySaved);
    }

    @Override
    @Transactional
    public void delete(@NonNull Long id) throws ParamNotFound {
        Optional<ScheduleEntity> opt = scheduleRepository.findById(id);
        if (opt.isPresent()) {
            scheduleRepository.delete(opt.get());
        } else {
            throw new ParamNotFound("Schedule not found");
        }
    }
            
    @Override
    @Transactional
    public ScheduleDTO update(@NonNull Long id, ScheduleDTO schedule) {
        Optional<ScheduleEntity> opt = scheduleRepository.findById(id);
        if (opt.isPresent()) {
            scheduleMapper.scheduleEntityRefreshValues(opt.get(), schedule);
            ScheduleEntity scheduleSaved = scheduleRepository.save(opt.get());
            return scheduleMapper.scheduleEntity2DTO(scheduleSaved);
        } else {
            throw new ParamNotFound("Schedule not found");
        }
    }

    @Override
    public List<ScheduleDTO> findAll() throws ParamNotFound {
        List<ScheduleEntity> entities = scheduleRepository.findAll();
        return scheduleMapper.scheduleEntityList2DTOList(entities);
    }

    @Override
    public ScheduleDTO findById(@NonNull Long id) {
        Optional<ScheduleEntity> opt = scheduleRepository.findById(id);
        if (opt.isPresent()) {
            return scheduleMapper.scheduleEntity2DTO(opt.get());
        } else {
            throw new ParamNotFound("Schedule not found");
        }
    }
    
}
