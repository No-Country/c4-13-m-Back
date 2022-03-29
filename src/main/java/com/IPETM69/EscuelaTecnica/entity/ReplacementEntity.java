package com.IPETM69.EscuelaTecnica.entity;

import lombok.Getter;
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

    public ReplacementEntity() {
    }

    public ReplacementEntity(Long id, String firstName, String lastName, String dni, Long phone, String email, String file, Activity[] activities, Boolean esTitular, PositionEnum name, Date checkIn, Date checkOut, EmployeeEntity replaceWho) {
        super(id, firstName, lastName, dni, phone, email, file, activities, esTitular);
        this.name = name;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.replaceWho = replaceWho;
    }

}
