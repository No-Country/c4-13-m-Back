/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.IPETM69.EscuelaTecnica.dto;

import com.IPETM69.EscuelaTecnica.entity.ClassEntity;
import com.IPETM69.EscuelaTecnica.entity.TimeEntity;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ActivityDTO {
    
    private Long id;
    private String name;
    private List<TimeEntity> times;
    private List<ClassEntity> classes;
    private Boolean esCargo;
    
}
