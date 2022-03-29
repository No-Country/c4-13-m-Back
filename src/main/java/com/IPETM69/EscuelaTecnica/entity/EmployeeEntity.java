package com.IPETM69.EscuelaTecnica.entity;

import java.util.Arrays;

public class EmployeeEntity {

    private Long id;
    private String firstName;
    private String lastName;
    private String dni;
    private Long phone;
    private String email;
    private String file;
    private Activity[] activities; // donde se ponian los corchetes??
    private Boolean esTitular;

    public EmployeeEntity() {
    }

    public EmployeeEntity(Long id, String firstName, String lastName, String dni, Long phone, String email, String file, Activity[] activities, Boolean esTitular) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
        this.file = file;
        this.activities = activities;
        this.esTitular = esTitular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public Activity[] getActivities() {
        return activities;
    }

    public void setActivities(Activity[] activities) {
        this.activities = activities;
    }

    public Boolean getEsTitular() {
        return esTitular;
    }

    public void setEsTitular(Boolean esTitular) {
        this.esTitular = esTitular;
    }

    @Override
    public String toString() {
        return "EmployeeEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dni='" + dni + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", file='" + file + '\'' +
                ", activities=" + Arrays.toString(activities) +
                ", esTitular=" + esTitular +
                '}';
    }
}
