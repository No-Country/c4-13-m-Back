package com.IPETM69.EscuelaTecnica.service.impl;

import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import com.IPETM69.EscuelaTecnica.auth.repository.UserRepository;
import com.IPETM69.EscuelaTecnica.dto.request.SettingDTORequest;
import com.IPETM69.EscuelaTecnica.dto.response.SettingDTOResponse;
import com.IPETM69.EscuelaTecnica.mapper.SettingMapper;
import com.IPETM69.EscuelaTecnica.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettingServiceImpl implements SettingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SettingMapper settingMapper;

    public SettingDTOResponse updatePassword(Long id, SettingDTORequest settingDTORequest){
        UserEntity userEntity = userRepository.getById(id);
        if(settingDTORequest.getActualPassword() == userEntity.getPassword() &&
                settingDTORequest.getNewPassword() == settingDTORequest.getRepeatNewPassword()){
            String newPassword = settingDTORequest.getNewPassword();
            userEntity.setPassword(newPassword);
        }
        //settingMapper.refreshValues(userEntity,settingDTORequest);
        SettingDTOResponse response = settingMapper.settingReq2Res(settingDTORequest);
        return response;
    }

}
