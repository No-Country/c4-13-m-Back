package com.IPETM69.EscuelaTecnica.entity;

import com.IPETM69.EscuelaTecnica.enumeration.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "classes")
public class ClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String grade;
    private String division;
    private ShiftEnum shift;
    private String department;



}
