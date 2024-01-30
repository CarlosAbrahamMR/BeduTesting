package com.spring.security.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@ToString
@Table(name="inactive_employees")
public class pending {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastNames;


    private String email;

    private int absences;


    private String phone;
    private String curp;

    private String rfc;

    private String nss;

    private double salary;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate birthdate;

    private int is_active;


    @Column()
    private String reason_leaving;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate day_leaving;

    private String department;

//    @JsonManagedReference
//    @OneToMany(mappedBy = "inactive_employees", cascade = CascadeType.PERSIST)
//    private List<Assistance> assistance;
}
