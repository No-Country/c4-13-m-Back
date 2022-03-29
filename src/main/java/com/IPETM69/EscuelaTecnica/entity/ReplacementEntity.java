package com.IPETM69.EscuelaTecnica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplacementEntity extends EmployeeEntity {

    private PositionEnum name;

    @Column(name = "fecha_ingreso")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate checkIn;

    @Column(name = "fecha_egreso")
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate checkOut;

    @OneToOne
    @JoinColumn(name = "replace_who_id")
    private EmployeeEntity replaceWho;

}
