package com.IPETM69.EscuelaTecnica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="empleados")
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "dni")
    private String dni;

    @Column(name = "phone")
    private Long phone;

    private String email;

    @Column(name = "legajo")
    private String file;

    @Column(name = "activities")
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE

            }
    )
    @JoinTable(
            name = "employee_activities",
            joinColumns = @JoinColumn(name = "id_empleados"),
            inverseJoinColumns = @JoinColumn(name = "id_actividades")
    )
    private List<ActivityEntity> activities = new ArrayList<>();

    @Column(name = "es_titular?")
    private Boolean esTitular;


}
