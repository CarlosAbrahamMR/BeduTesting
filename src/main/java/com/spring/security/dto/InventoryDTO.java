package com.spring.security.dto;

import com.spring.security.model.Department;
import jakarta.persistence.Column;
import lombok.Data;

@Data
public class InventoryDTO {
    private long id;

    private String name;

    private int quantity;

    private String description;

    private Department department;

}
