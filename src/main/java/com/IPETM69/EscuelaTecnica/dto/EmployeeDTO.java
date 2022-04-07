package com.IPETM69.EscuelaTecnica.dto;

import com.IPETM69.EscuelaTecnica.entity.ScheduleEntity;
import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private String dni;
    private Long phone;
    private String email;
    private String file;
    private List<ScheduleEntity> schedules = new ArrayList<>();

}
