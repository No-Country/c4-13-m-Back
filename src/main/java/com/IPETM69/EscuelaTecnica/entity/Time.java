package com.IPETM69.EscuelaTecnica.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "times")
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Enum day;

    @Column(name = "time_in")
    private String timeIn;

    @Column(name = "time_out")
    private String timeOut;

}
