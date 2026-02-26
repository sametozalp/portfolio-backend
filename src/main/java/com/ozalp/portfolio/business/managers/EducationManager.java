package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateEducationRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateEducationRequest;
import com.ozalp.portfolio.business.dtos.responses.EducationResponse;
import com.ozalp.portfolio.business.mappers.EducationMapper;
import com.ozalp.portfolio.business.services.EducationService;
import com.ozalp.portfolio.dataAccess.EducationRepository;
import com.ozalp.portfolio.entities.Education;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EducationManager implements EducationService {

    private final EducationRepository repository;
    private final EducationMapper mapper;

    @Override
    public void add(CreateEducationRequest createEducationRequest) {
        repository.save(mapper.toEntity(createEducationRequest));
    }

    @Override
    public void delete(int id) {
        var entity = findById(id);
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void setShowable(int id, Boolean value) {
        Education education = findById(id);
        education.setShowable(value);
        repository.save(education);
    }

    @Override
    public Education findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public List<EducationResponse> getEducations() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void update(int id, UpdateEducationRequest request) {
        var entity = findById(id);
        mapper.updateEntity(request, entity);
        repository.save(entity);
    }
}
