package com.IPETM69.EscuelaTecnica.dto;

import com.IPETM69.EscuelaTecnica.entity.ActivityEntity;
import com.IPETM69.EscuelaTecnica.enumeration.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClassDto {
    private Long id;
    private String grade;
    private String division;
    private String shift;
    private String department;
    private List<ActivityEntity> activities;
}
