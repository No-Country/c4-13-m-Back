package com.IPETM69.EscuelaTecnica.entity;

import java.util.Date;

public class ReplacementEntity extends EmployeeEntity {

    private PositionEnum name;
    private Date checkIn;
    private Date checkOut;
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

    public PositionEnum getName() {
        return name;
    }

    public void setName(PositionEnum name) {
        this.name = name;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public EmployeeEntity getReplaceWho() {
        return replaceWho;
    }

    public void setReplaceWho(EmployeeEntity replaceWho) {
        this.replaceWho = replaceWho;
    }
}
