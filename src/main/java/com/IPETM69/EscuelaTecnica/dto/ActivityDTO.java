package com.IPETM69.EscuelaTecnica.dto;

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
    private Boolean esCargo;
    
}
