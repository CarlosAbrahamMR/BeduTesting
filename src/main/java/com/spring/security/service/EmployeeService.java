package com.spring.security.service;
import com.spring.security.advice.NotFoundException;
import com.spring.security.dto.EmployeeDto;
import com.spring.security.mapper.EmployeeMapper;
import com.spring.security.model.Employee;
import com.spring.security.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    
    @Autowired
    private EmployeeRepository repository;
    @Autowired
    private EmployeeMapper mapper;
    
    public List<EmployeeDto> findAll() throws NotFoundException{

        return repository.findAll().stream().map(mapper::toDTO).toList();
    }


    public List<Employee> findByShift(Long ShiftId) {
        return repository.findByShiftId(ShiftId);
    }

    public List<Employee> findByDepartment(String department) {
        return repository.findByDepartment(department);
    }

    public List<Employee> findByContractedSignedFalse() {
        return repository.findByContractedSignedFalse();
    }

    public EmployeeDto save(EmployeeDto data) {
        Employee entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }

    public List<EmployeeDto> saveAll(List<EmployeeDto> dataList) {
        List<Employee> entities = dataList.stream()
                .map(data -> repository.save(mapper.toModel(data)))
                .collect(Collectors.toList());

        return entities.stream()
                .map(entity -> mapper.toDTO(entity))
                .collect(Collectors.toList());
    }


    public void update(long id, EmployeeDto data) throws NotFoundException {
        Optional<Employee> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new NotFoundException(id);
        }

        Employee model = result.get();

        mapper.update(model, data);

        repository.save(model);
    }

    public void deleteById(long id) throws NotFoundException {

        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }

        repository.deleteById(id);

    }

    public EmployeeDto findById(Long id) throws NotFoundException{
        Optional<Employee> result = repository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException(id);
        }
        Employee employee = result.get();
        return mapper.toDTO(employee);
    }
}
