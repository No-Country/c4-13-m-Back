package com.IPETM69.EscuelaTecnica.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestLoginDTO {
    @NotBlank
    @Email
    private String username;
    @NotBlank
    private String password;
}
