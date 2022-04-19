package com.IPETM69.EscuelaTecnica.auth.dto;

import com.IPETM69.EscuelaTecnica.auth.entity.RoleEntity;
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
    private String photo;
    private RoleEntity role;
    private String token;
    
}
