package com.spring.security.repository;

import com.spring.security.model.Employee;
import com.spring.security.model.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    @Query("SELECT e FROM Employee e WHERE e.shift.id = :shiftId")
    List<Employee> findByShiftId(@Param("shiftId") Long shiftId);

    @Query("SELECT e FROM Employee e WHERE e.department = :department")
    List<Employee> findByDepartment(@Param("department") String department);

    @Query("SELECT e FROM Employee e WHERE e.is_contracted_signed = false")
    List<Employee> findByContractedSignedFalse();
}
