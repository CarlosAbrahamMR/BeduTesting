package com.spring.security.mapper;

import com.spring.security.dto.InventoryDTO;
import com.spring.security.model.Inventory;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InventoryMapper {

    InventoryDTO toDTO(Inventory model);


    Inventory toModel(InventoryDTO dto);

//    @Mapping(target = "assistance", ignore = true)
    void update(@MappingTarget Inventory model, InventoryDTO dto);
}
