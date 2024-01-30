package com.spring.security.service;

import com.spring.security.advice.NotFoundException;
import com.spring.security.dto.InventoryDTO;
import com.spring.security.mapper.InventoryMapper;
import com.spring.security.model.Inventory;
import com.spring.security.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository repository;
    @Autowired
    private InventoryMapper mapper;

    public List<InventoryDTO> findAll() throws NotFoundException{

        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public InventoryDTO save(InventoryDTO data) {
        Inventory entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }


    public void update(long id, InventoryDTO data) throws NotFoundException {
        Optional<Inventory> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new NotFoundException(id);
        }

        Inventory model = result.get();

        mapper.update(model, data);

        repository.save(model);
    }

    public void deleteById(long id) throws NotFoundException {

        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }

        repository.deleteById(id);

    }

    public InventoryDTO findById(Long id) throws NotFoundException{
        Optional<Inventory> result = repository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException(id);
        }
        Inventory inventory = result.get();
        return mapper.toDTO(inventory);
    }
}
