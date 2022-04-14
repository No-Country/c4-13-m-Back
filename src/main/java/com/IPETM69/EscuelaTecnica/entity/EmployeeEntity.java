package com.IPETM69.EscuelaTecnica.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class EmployeeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employees_id")
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    private String dni;

    private Long phone;

    private String email;

    @Column(name = "legajo")
    private String file;

    @Column(name = "schedules")
    @OneToMany(cascade = CascadeType.ALL)
    private List<ScheduleEntity> schedules = new ArrayList<>();

}
