package com.IPETM69.EscuelaTecnica.entity;

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
public class EmployeeEntity {

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

    @Column(name = "activities")
    @OneToMany(cascade = CascadeType.ALL)
    private List<ActivityEntity> activities = new ArrayList<>();

}
