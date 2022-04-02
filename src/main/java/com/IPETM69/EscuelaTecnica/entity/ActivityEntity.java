package com.IPETM69.EscuelaTecnica.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "activities")
public class ActivityEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name; 
    private List<TimeEntity> times = new ArrayList<>();
    private List<ClassEntity> classes = new ArrayList<>();
    private Boolean esCargo;

    
}
