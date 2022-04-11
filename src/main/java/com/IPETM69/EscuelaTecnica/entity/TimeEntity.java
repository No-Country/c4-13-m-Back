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

    @Column(name = "hour_in")
    private String hourIn;

    @Column(name = "minute_in")
    private String minuteIn;

    @Column(name = "hour_out")
    private String hourOut;

    @Column(name = "minute_out")
    private String minuteOut;

}
