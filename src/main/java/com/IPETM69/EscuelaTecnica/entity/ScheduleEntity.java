package com.IPETM69.EscuelaTecnica.entity;

import com.IPETM69.EscuelaTecnica.enumeration.PositionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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

    @JoinColumn(name = "activity_id")
    @OneToOne
    private ActivityEntity activity;

    @JoinColumn(name = "class_id")
    @OneToOne
    private ClassEntity classEntity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TimeEntity> times;

    @JoinColumn(name = "employee_id")
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private EmployeeEntity employee;

    @OneToOne(cascade = CascadeType.ALL)
    private ReplacementEntity replacement;

    @Enumerated(EnumType.STRING)
    private PositionEnum position;
    
}
