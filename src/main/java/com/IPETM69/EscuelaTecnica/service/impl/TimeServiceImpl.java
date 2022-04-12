package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.dto.TimeDTO;
import com.IPETM69.EscuelaTecnica.dto.TimePrintDTO;
import com.IPETM69.EscuelaTecnica.entity.TimeEntity;
import com.IPETM69.EscuelaTecnica.exception.ParamNotFound;
import com.IPETM69.EscuelaTecnica.mapper.TimeMapper;
import com.IPETM69.EscuelaTecnica.repository.TimeRepository;
import com.IPETM69.EscuelaTecnica.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TimeServiceImpl implements TimeService {

    @Autowired
    private TimeRepository timeRepository;

    @Autowired
    private TimeMapper timeMapper;

    @Override
    public TimePrintDTO save(TimeDTO dto) {
        TimeEntity entity = timeMapper.timeDTO2Entity(dto);
        TimeEntity entitySaved = timeRepository.save(entity);
        TimePrintDTO result = timeMapper.timeEntity2DTO(entitySaved);
        return result;

    }

//    @Override
//    public TimeDTO findTimeById(Long id) {
//
//        Optional<TimeEntity> entity = timeRepository.findById(id);
//        if (!entity.isPresent()){
//            throw new ParamNotFound("ID");
//        }
//        TimeDTO result = timeMapper.timeEntity2DTO(entity.get());
//        return result;
//
//    }

    @Override
    public TimePrintDTO update(Long id, TimeDTO dto) {
        Optional<TimeEntity> entity = timeRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("ID");
        }
        timeMapper.timeEntityRefreshValues(entity.get(), dto);
        TimeEntity entitySaved = timeRepository.save(entity.get());
        TimePrintDTO result = timeMapper.timeEntity2DTO(entitySaved);
        return result;    }


    @Override
    public void delete(Long id) {
        Optional<TimeEntity> entity = timeRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("ID");
        }
        timeRepository.deleteById(id);
    }



 }



