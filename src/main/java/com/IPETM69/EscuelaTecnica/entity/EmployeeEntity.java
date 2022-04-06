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
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class EmployeeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employees_id")
    protected Long id;

    @Column(name = "first_name")
    protected String firstName;

    @Column(name = "last_name")
    protected String lastName;

    protected String dni;

    protected Long phone;

    protected String email;

    @Column(name = "legajo")
    protected String file;

    @Column(name = "activities")
    @OneToMany(cascade = CascadeType.ALL)
    protected List<ActivityEntity> activities = new ArrayList<>();

}
