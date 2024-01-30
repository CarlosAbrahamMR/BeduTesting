package com.spring.security.service;

import com.spring.security.advice.NotFoundException;
import com.spring.security.dto.AssistanceDto;
import com.spring.security.dto.InventoryDTO;
import com.spring.security.dto.ShiftDTO;
import com.spring.security.mapper.AssistanceMapper;
import com.spring.security.mapper.InventoryMapper;
import com.spring.security.mapper.ShiftMapper;
import com.spring.security.model.Assistance;
import com.spring.security.model.Inventory;
import com.spring.security.model.Shift;
import com.spring.security.repository.AssistanceRepository;
import com.spring.security.repository.InventoryRepository;
import com.spring.security.repository.ShiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShiftService {

    @Autowired
    private ShiftRepository repository;
    @Autowired
    private ShiftMapper mapper;

    public List<ShiftDTO> findAll() throws NotFoundException{

        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public ShiftDTO save(ShiftDTO data) {
        Shift entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }


    public void update(long id, ShiftDTO data) throws NotFoundException {
        Optional<Shift> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new NotFoundException(id);
        }

        Shift model = result.get();

        mapper.update(model, data);

        repository.save(model);
    }

    public void deleteById(long id) throws NotFoundException {

        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }

        repository.deleteById(id);

    }

    public ShiftDTO findById(Long id) throws NotFoundException{
        Optional<Shift> result = repository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException(id);
        }
        Shift shift = result.get();
        return mapper.toDTO(shift);
    }
}
