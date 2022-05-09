package com.IPETM69.EscuelaTecnica.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SettingDTOResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String position;

}
