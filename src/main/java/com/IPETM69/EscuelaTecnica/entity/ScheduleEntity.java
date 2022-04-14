package com.IPETM69.EscuelaTecnica.entity;

import com.IPETM69.EscuelaTecnica.enumeration.PositionEnum;
import java.io.Serializable;
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
@Table(name = "schedules")
public class ScheduleEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idActivity;
    private Long idClass;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TimeEntity> times;


    private Long idEmployee;
    @OneToOne(cascade = CascadeType.ALL)
    private ReplacementEntity replacement;
    @Enumerated(EnumType.STRING)
    private PositionEnum position;
    
}
