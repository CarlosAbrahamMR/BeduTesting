package com.spring.security.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PendingDTO {
    private long id;

    private String firstName;

    private String lastNames;

    private String phone;

    private String email;

    private String curp;

    private String rfc;

    private String nss;

    private double salary;


    private LocalDate birthdate;

    private int absences;

    private int is_active;

    private LocalDate day_leaving;

    private String reason_leaving;

    private String department;

    //private List<Assistance> assistance;
}
