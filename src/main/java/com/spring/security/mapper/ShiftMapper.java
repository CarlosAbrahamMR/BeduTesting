package com.spring.security.mapper;

import com.spring.security.dto.ShiftDTO;
import com.spring.security.model.Shift;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ShiftMapper {
    ShiftDTO toDTO(Shift model);


    Shift toModel(ShiftDTO dto);

//    @Mapping(target = "assistance", ignore = true)
    void update(@MappingTarget Shift model, ShiftDTO dto);
}
