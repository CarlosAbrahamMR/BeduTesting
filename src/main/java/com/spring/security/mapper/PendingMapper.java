package com.spring.security.mapper;

import com.spring.security.dto.PendingDTO;
import com.spring.security.model.pending;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PendingMapper {

    PendingDTO toDTO(pending model);


    pending toModel(PendingDTO dto);

//    @Mapping(target = "assistance", ignore = true)
@Mapping(target = "id", ignore = true)
    void update(@MappingTarget pending model, PendingDTO dto);
}
