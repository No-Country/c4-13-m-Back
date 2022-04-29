package com.IPETM69.EscuelaTecnica.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserProfileDTO {
    
    private String firstName;
    private String lastName;
    private String email;
    private String photo;
    
}