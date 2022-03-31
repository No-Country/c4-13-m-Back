package com.IPETM69.EscuelaTecnica.entity;

import com.IPETM69.EscuelaTecnica.enumeration.ShiftEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
<<<<<<< HEAD
=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> b907c0f7424b06a3b6769c2ff3d60b100ad6c0cd

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
    //private List <ActivityEntity> activities = new ArrayList<>();

}
