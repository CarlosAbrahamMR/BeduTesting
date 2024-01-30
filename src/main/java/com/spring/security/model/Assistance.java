package com.spring.security.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@ToString
@Table(name="assistance")
public class Assistance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate day;

    @Column(nullable = false,columnDefinition = "TIME")
    private Time entry;

    @Column(nullable = false,columnDefinition = "TIME")
    private Time leave;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

    }
