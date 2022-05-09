package com.IPETM69.EscuelaTecnica.controller;

import com.IPETM69.EscuelaTecnica.dto.request.SettingDTORequest;
import com.IPETM69.EscuelaTecnica.dto.response.SettingDTOResponse;
import com.IPETM69.EscuelaTecnica.service.SettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("settings")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SettingDTOResponse updatePassword(@PathVariable Long id ,@RequestBody SettingDTORequest settingDTORequest){
        SettingDTOResponse response = settingService.updatePassword(id, settingDTORequest);
        return response;
    }

}
