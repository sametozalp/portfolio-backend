package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateExperienceRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateExperienceRequest;
import com.ozalp.portfolio.business.dtos.responses.ExperienceResponse;
import com.ozalp.portfolio.business.mappers.ExperienceMapper;
import com.ozalp.portfolio.business.services.ExperienceService;
import com.ozalp.portfolio.dataAccess.ExperienceRepository;
import com.ozalp.portfolio.entities.Experience;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExperienceManager implements ExperienceService {

    private final ExperienceRepository repository;
    private final ExperienceMapper mapper;

    @Override
    public void add(CreateExperienceRequest createExperienceRequest) {
        repository.save(mapper.toEntity(createExperienceRequest));
    }

    @Override
    public void delete(int id) {
        var entity = findById(id);
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void setShowable(int id, Boolean value) {
        Experience experience = findById(id);
        experience.setShowable(value);
        repository.save(experience);
    }

    @Override
    public Experience findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public List<ExperienceResponse> getExperience() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void update(int id, UpdateExperienceRequest request) {
        var entity = findById(id);
        mapper.updateEntity(request, entity);
        repository.save(entity);
    }
}
