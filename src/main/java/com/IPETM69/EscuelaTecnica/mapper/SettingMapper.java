package com.IPETM69.EscuelaTecnica.mapper;

import com.IPETM69.EscuelaTecnica.auth.entity.UserEntity;
import com.IPETM69.EscuelaTecnica.dto.request.SettingDTORequest;
import com.IPETM69.EscuelaTecnica.dto.response.SettingDTOResponse;
import org.springframework.stereotype.Component;

@Component
public class SettingMapper {

    public void refreshValues(UserEntity userEntity, SettingDTORequest settingDTORequest){
        settingDTORequest.setFirstName(userEntity.getFirstName());
        settingDTORequest.setLastName(userEntity.getLastName());
        settingDTORequest.setEmail(userEntity.getEmail());
    }

    public SettingDTOResponse settingReq2Res(SettingDTORequest req){
        SettingDTOResponse response = new SettingDTOResponse();
        response.setFirstName(req.getFirstName());
        response.setLastName(req.getLastName());
        response.setEmail(req.getEmail());
        response.setPosition(req.getPosition());
        return response;
    }

}
