package com.IPETM69.EscuelaTecnica.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTORequest {

    private String firstName;
    private String lastName;
    private String dni;
    private Long phone;
    private String email;
    private String file;

}
