package com.IPETM69.EscuelaTecnica.dto;

import com.IPETM69.EscuelaTecnica.entity.ActivityEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeFilterDTO {

    private String firstName;
    private String lastName;
    private String dni;
    private Long phone;
    private String email;
    private String file;
    private List<ActivityEntity> activities = new ArrayList<>();

}
