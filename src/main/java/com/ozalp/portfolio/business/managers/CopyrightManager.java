package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateCopyrightRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateCopyrightRequest;
import com.ozalp.portfolio.business.dtos.responses.CopyrightResponse;
import com.ozalp.portfolio.business.exeptions.errors.DataAlreadyExist;
import com.ozalp.portfolio.business.mappers.CopyrightMapper;
import com.ozalp.portfolio.business.services.CopyrightService;
import com.ozalp.portfolio.dataAccess.CopyrightRepository;
import com.ozalp.portfolio.entities.Copyright;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CopyrightManager implements CopyrightService {

    private final CopyrightRepository repository;
    private final CopyrightMapper mapper;

    @Override
    public void add(CreateCopyrightRequest createCopyrightRequest) {
        if (!repository.findAll().isEmpty()) {
            throw new DataAlreadyExist();
        }
        repository.save(mapper.toEntity(createCopyrightRequest));
    }

    @Override
    public void delete(int id) {
        var entity = findById(id);
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void setShowable(int id, Boolean value) {
        Copyright copyright = findById(id);
        copyright.setShowable(value);
        repository.save(copyright);
    }

    @Override
    public Copyright findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public CopyrightResponse getCopyright() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(int id, UpdateCopyrightRequest request) {
        var entity = findById(id);
        mapper.updateEntity(request, entity);
        repository.save(entity);
    }
}
