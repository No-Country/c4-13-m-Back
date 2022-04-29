package com.IPETM69.EscuelaTecnica.auth.dto;

import com.IPETM69.EscuelaTecnica.auth.enums.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseRegisterDTO {
    
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Roles role;
    private String token;
    
}
