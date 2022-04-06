package com.IPETM69.EscuelaTecnica.entity;


import com.IPETM69.EscuelaTecnica.enumeration.PositionEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class ReplacementEntity extends EmployeeEntity {

    private PositionEnum name = null;

    @Column(name = "fecha_ingreso")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkIn = null;

    @Column(name = "fecha_egreso")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOut = null;

    @OneToOne
    @JoinColumn(name = "replace_who_id")
    private EmployeeEntity replaceWho = null;
}

