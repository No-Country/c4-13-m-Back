package com.IPETM69.EscuelaTecnica.auth.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterUserDTO {
    
    @NotNull
    private Long id;
    @NotNull
    private String email;
    @NotNull
    private String password;
    @NotNull
    private String password2;
    
}
