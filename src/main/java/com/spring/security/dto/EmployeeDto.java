package com.spring.security.dto;

import com.spring.security.model.Assistance;
import com.spring.security.model.Department;
import com.spring.security.model.Inventory;
import com.spring.security.model.Shift;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class EmployeeDto {

    private long id;

    private long idEmployee;

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

    private boolean is_active;

    private boolean is_contracted_signed;

    private boolean is_responsive_signed;

    private boolean is_dismissed_required;

    private boolean is_imss_assignated;

    private LocalDate day_leaving;

    private String reason_leaving;

    private Department department;

    private List<Assistance> assistance;

    private Shift shift;

    private Set<Inventory> inventory;
}

