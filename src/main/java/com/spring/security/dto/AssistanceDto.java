package com.spring.security.dto;

import com.spring.security.model.Employee;
import lombok.Data;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class AssistanceDto {
    private long id;

    private LocalDate day;

    private Time entry;

    private Time leave;

    private Employee employee;

}
