package com.IPETM69.EscuelaTecnica.entity;

import com.IPETM69.EscuelaTecnica.enumeration.DayEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate timeIn;

    @Column(name = "time_out")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate timeOut;

}
