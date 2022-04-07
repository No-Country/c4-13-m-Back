package com.IPETM69.EscuelaTecnica.entity;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.time.LocalDate;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "replacements")
public class ReplacementEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "check_in")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkIn = null;

    @Column(name = "check_out")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate checkOut = null;


//    @OneToOne
//    @JoinColumn(name = "replace_who_id")
//    private EmployeeEntity replaceWho;


}

