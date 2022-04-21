package com.IPETM69.EscuelaTecnica.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTOResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private Long phone;
    private String email;
    private String file;
    private List<ScheduleBasicDtoResponse> schedules = new ArrayList<>();

}
