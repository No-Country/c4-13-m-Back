package com.IPETM69.EscuelaTecnica.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeBasicDTO {
    private Long id;
    private String firstName;
    private String lastName;
}
