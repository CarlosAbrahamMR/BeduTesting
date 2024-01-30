package com.spring.security.service;
import com.spring.security.advice.NotFoundException;
import com.spring.security.dto.AssistanceDto;
import com.spring.security.mapper.AssistanceMapper;
import com.spring.security.model.Assistance;
import com.spring.security.repository.AssistanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssistanceService {

    @Autowired
    private AssistanceRepository repository;
    @Autowired
    private AssistanceMapper mapper;

    public List<AssistanceDto> findAll() {

        return repository.findAll().stream().map(mapper::toDTO).toList();
    }

    public AssistanceDto save(AssistanceDto data) {
        Assistance entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }


//    public void update(long id, AssistanceDto data) throws NotFoundException {
//        Optional<Assistance> result = repository.findById(id);
//
//        if (result.isEmpty()) {
//            throw new NotFoundException(id);
//        }
//
//        Assistance model = result.get();
//
//        mapper.update(model, data);
//
//        repository.save(model);
//    }

    public void deleteById(long id) throws NotFoundException {

        if (!repository.existsById(id)) {
            throw new NotFoundException(id);
        }

        repository.deleteById(id);

    }

//    public AssistanceDto findById(Long id) throws NotFoundException{
//        Optional<Assistance> result = repository.findById(id);
//        if (result.isEmpty()) {
//            throw new NotFoundException(id);
//        }
//        Assistance assistance = result.get();
//        return mapper.toDTO(assistance);
//    }
}


