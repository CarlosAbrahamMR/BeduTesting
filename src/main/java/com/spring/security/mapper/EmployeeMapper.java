package com.spring.security.mapper;
import com.spring.security.dto.AssistanceDto;
import com.spring.security.dto.EmployeeDto;
import com.spring.security.model.Assistance;
import com.spring.security.model.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface EmployeeMapper {

    EmployeeDto toDTO(Employee model);


    Employee toModel(EmployeeDto dto);

    @Mapping(target = "assistance", ignore = true)
    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Employee model, EmployeeDto dto);
//    @Mapping(target = "equipment", ignore = true) // Avoid circular dependency
//    Departament toModelAdd(dtoDepartament dto);
}
