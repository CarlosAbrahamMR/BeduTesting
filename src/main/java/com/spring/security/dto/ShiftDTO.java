package com.spring.security.dto;

import com.spring.security.model.Employee;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Time;
import java.util.List;

@Data
public class ShiftDTO {

    private long id;

    private String name;

    private Time entry;

    private Time leaving;

    private List<Employee> employees;
}
