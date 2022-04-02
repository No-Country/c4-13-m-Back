/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.dto.ActivityDTO;
import com.IPETM69.EscuelaTecnica.entity.ActivityEntity;
import com.IPETM69.EscuelaTecnica.exception.ActivityNotFoundException;
import com.IPETM69.EscuelaTecnica.mapper.ActivityMapper;
import com.IPETM69.EscuelaTecnica.repository.ActivityRepository;
import com.IPETM69.EscuelaTecnica.service.ActivityService;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ActivityServiceImpl implements ActivityService {
    
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    @Transactional
    public ActivityDTO create(ActivityDTO activity) {
        ActivityEntity entity = activityMapper.activityDTO2Entity(activity);
        ActivityEntity entitySaved = activityRepository.save(entity);
        return activityMapper.activityEntity2DTO(entitySaved);
    }

    @Override
    @Transactional
    public void delete(@NonNull Long id) throws ActivityNotFoundException {
        Optional<ActivityEntity> opt = activityRepository.findById(id);
        if (opt.isPresent()) {
            activityRepository.delete(opt.get());
        } else {
            throw new ActivityNotFoundException("Activity not found");
        }
    }
            
    @Override
    @Transactional
    public ActivityDTO update(@NonNull Long id, ActivityDTO activity) {
        Optional<ActivityEntity> opt = activityRepository.findById(id);
        if (opt.isPresent()) {
            activityMapper.activityEntityRefreshValues(opt.get(), activity);
            ActivityEntity entitySaved = activityRepository.save(opt.get());
            return activityMapper.activityEntity2DTO(entitySaved);
        } else {
            throw new ActivityNotFoundException("Activity not found");
        }
    }

    @Override
    public List<ActivityDTO> findAll() throws ActivityNotFoundException {
        List<ActivityEntity> entities = activityRepository.findAll();
        return activityMapper.activityEntityList2DTOList(entities);
    }

    @Override
    public ActivityDTO findById(@NonNull Long id) {
        Optional<ActivityEntity> opt = activityRepository.findById(id);
        if (opt.isPresent()) {
            return activityMapper.activityEntity2DTO(opt.get());
        } else {
            throw new ActivityNotFoundException("Activity not found");
        }
    }
    
}
