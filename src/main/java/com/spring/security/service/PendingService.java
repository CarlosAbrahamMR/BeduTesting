package com.spring.security.service;

import com.spring.security.advice.NotFoundException;
import com.spring.security.dto.PendingDTO;
import com.spring.security.mapper.PendingMapper;
import com.spring.security.model.pending;
import com.spring.security.repository.PendingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PendingService {

    @Autowired
    private PendingRepository repository;
    @Autowired
    private PendingMapper mapper;

    public List<PendingDTO> findAll() throws NotFoundException{

        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public PendingDTO save(PendingDTO data) {
        pending entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }


    public void update(long id, PendingDTO data) throws NotFoundException {
        Optional<pending> result = repository.findById(id);

        if (result.isEmpty()) {
            throw new NotFoundException(id);
        }

        pending model = result.get();

        mapper.update(model, data);

        repository.save(model);
    }

    public void deleteById(long id) throws NotFoundException {

        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }

        repository.deleteById(id);

    }

    public PendingDTO findById(Long id) throws NotFoundException{
        Optional<pending> result = repository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException(id);
        }
        pending employee = result.get();
        return mapper.toDTO(employee);
    }
}
