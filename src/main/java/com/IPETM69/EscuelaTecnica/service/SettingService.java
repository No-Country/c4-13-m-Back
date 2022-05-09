package com.IPETM69.EscuelaTecnica.service;

import com.IPETM69.EscuelaTecnica.dto.request.SettingDTORequest;
import com.IPETM69.EscuelaTecnica.dto.response.SettingDTOResponse;

public interface SettingService {

    SettingDTOResponse updatePassword(Long id, SettingDTORequest settingDTORequest);

}
