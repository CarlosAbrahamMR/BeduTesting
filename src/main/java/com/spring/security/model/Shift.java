package com.spring.security.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@ToString
@Table(name="shift")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false,columnDefinition = "TIME")
    private Time entry;

    @Column(nullable = false,columnDefinition = "TIME")
    private Time leaving;

//    @JsonBackReference
//    @ManyToOne
//    @JoinColumn(name = "id_employee")
//    private Employee employee;
    @JsonManagedReference
    @OneToMany(mappedBy = "shift", cascade = CascadeType.PERSIST)
    private List<Employee> employees;

}
