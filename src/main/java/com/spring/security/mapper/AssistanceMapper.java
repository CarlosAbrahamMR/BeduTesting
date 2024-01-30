package com.spring.security.mapper;


import com.spring.security.dto.AssistanceDto;
import com.spring.security.model.Assistance;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface AssistanceMapper {
    AssistanceDto toDTO(Assistance model);

    @Mapping(target="id", ignore=true)
    Assistance toModel(AssistanceDto dto);


//    @Mapping(target = "id", ignore = true)
//    void update(@MappingTarget Departament model, dtoUpdateDepartament dto);
//    @Mapping(target = "equipment", ignore = true) // Avoid circular dependency
//    Departament toModelAdd(dtoDepartament dto);
}
