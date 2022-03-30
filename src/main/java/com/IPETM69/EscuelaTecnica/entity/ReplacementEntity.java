package com.IPETM69.EscuelaTecnica.entity;

import com.IPETM69.EscuelaTecnica.enumeration.PositionEnum;
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

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReplacementEntity extends EmployeeEntity {

    private PositionEnum name;

    @Column(name = "fecha_ingreso")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkIn;

    @Column(name = "fecha_egreso")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOut;

    @OneToOne
    @JoinColumn(name = "replace_who_id")
    private EmployeeEntity replaceWho;

}
