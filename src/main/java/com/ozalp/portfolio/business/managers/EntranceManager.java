package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateEntranceRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateEntranceRequest;
import com.ozalp.portfolio.business.dtos.responses.EntranceResponse;
import com.ozalp.portfolio.business.exeptions.errors.DataAlreadyExist;
import com.ozalp.portfolio.business.mappers.EntranceMapper;
import com.ozalp.portfolio.business.services.EntranceService;
import com.ozalp.portfolio.dataAccess.EntranceRepository;
import com.ozalp.portfolio.entities.Entrance;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntranceManager implements EntranceService {

    private final EntranceRepository repository;
    private final EntranceMapper mapper;

    @Override
    public void add(CreateEntranceRequest createEntranceRequest) {
        if (!repository.findAll().isEmpty()) {
            throw new DataAlreadyExist();
        }
        repository.save(mapper.toEntity(createEntranceRequest));
    }

    @Override
    public void delete(int id) {
        var entity = findById(id);
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void setShowable(int id, Boolean value) {
        Entrance entrance = findById(id);
        entrance.setShowable(value);
        repository.save(entrance);
    }

    @Override
    public Entrance findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public EntranceResponse getEntrance() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(int id, UpdateEntranceRequest request) {
        var entity = findById(id);
        mapper.updateEntity(request, entity);
        repository.save(entity);
    }
}
