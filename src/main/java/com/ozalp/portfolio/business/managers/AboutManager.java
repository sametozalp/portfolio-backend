package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateAboutRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateAboutRequest;
import com.ozalp.portfolio.business.dtos.responses.AboutResponse;
import com.ozalp.portfolio.business.exeptions.errors.DataAlreadyExist;
import com.ozalp.portfolio.business.mappers.AboutMapper;
import com.ozalp.portfolio.business.services.AboutService;
import com.ozalp.portfolio.dataAccess.AboutRepository;
import com.ozalp.portfolio.entities.About;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AboutManager implements AboutService {

    private final AboutRepository repository;
    private final AboutMapper mapper;

    @Override
    public void add(CreateAboutRequest createAboutRequest) {
        if (!repository.findAll().isEmpty()) {
            throw new DataAlreadyExist();
        }

        repository.save(mapper.toEntity(createAboutRequest));
    }

    @Override
    public void delete(int id) {
        var entity = findById(id);
        entity.markAsDeleted();
        repository.save(entity);
    }

    @Override
    public void setShowable(int id, Boolean value) {
        About about = findById(id);
        about.setShowable(value);
        repository.save(about);
    }

    @Override
    public About findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public AboutResponse getAbout() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(int id, UpdateAboutRequest request) {
        var entity = findById(id);
        mapper.updateEntity(request, entity);
        repository.save(entity);
    }

}
