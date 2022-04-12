package com.IPETM69.EscuelaTecnica.entity;

import com.IPETM69.EscuelaTecnica.enumeration.DayEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@Table(name = "times")
public class TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private DayEnum day;

    @Column(name = "time_in")
    private String timeIn;

    @Column(name = "time_out")
    private String timeOut;

}
