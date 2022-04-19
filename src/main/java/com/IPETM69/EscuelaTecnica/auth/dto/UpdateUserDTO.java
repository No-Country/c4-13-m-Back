
package com.IPETM69.EscuelaTecnica.auth.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserDTO {
    
    private String firstName;
    private String lastName;
    @Email
    private String email;
    private String password;
    @Pattern(regexp = "(USER|ADMIN)",message = "Just acept the role USER or ADMIN")
    private String role;
    
}
