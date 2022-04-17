package com.IPETM69.EscuelaTecnica.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilterDTOResponse {

    private String activity;
    private List<String> grade;
    private String department;
    private String employee;

}
