package com.IPETM69.EscuelaTecnica.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingDTORequest {

    private String firstName;
    private String lastName;
    private String email;
    private String position;
    private String actualPassword;
    private String newPassword;
    private String repeatNewPassword;

}
