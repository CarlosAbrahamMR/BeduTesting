package com.spring.security.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long idEmployee;

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

    private boolean is_active;


    @Column()
    private String reason_leaving;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate day_leaving;

    @Enumerated(EnumType.STRING)
    private Department department;

    private boolean is_contracted_signed;

    private boolean is_responsive_signed;

    private boolean is_dismissed_required;

    private boolean is_imss_assignated;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee", cascade = CascadeType.PERSIST)
    private List<Assistance> assistance;


//    @ManyToOne(mappedBy = "employee", cascade = CascadeType.PERSIST)
//    private List<Shift> shift;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "shift_id")
    private Shift shift;

    @ManyToMany
    @JoinTable(
            name = "asignaciones",
            joinColumns = @JoinColumn(name = "empleado_id"),
            inverseJoinColumns = @JoinColumn(name = "articulo_id"))
    private Set<Inventory> inventory = new HashSet<>();
}



