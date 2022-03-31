package com.IPETM69.EscuelaTecnica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name="empleados")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String firstName;

    @Column(name = "apellido")
    private String lastName;

    @Column(name = "dni")
    private String dni;

    @Column(name = "telefono")
    private Long phone;

    private String email;

    @Column(name = "legajo")
    private String file;

    @Column(name = "actividades")
    @ManyToMany(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE

            }
    )
    @JoinTable(
            name = "Actividades_de_empleados",
            joinColumns = @JoinColumn(name = "id_empleados"),
            inverseJoinColumns = @JoinColumn(name = "id_actividades")
    )
    private List<ActivityEntity> activities = new ArrayList<>();

    @Column(name = "es_titular?")
    private Boolean esTitular;


}
