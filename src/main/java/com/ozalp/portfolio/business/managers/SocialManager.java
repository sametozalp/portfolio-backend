package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateSocialRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateSocialRequest;
import com.ozalp.portfolio.business.dtos.responses.SocialResponse;
import com.ozalp.portfolio.business.mappers.SocialMapper;
import com.ozalp.portfolio.business.services.SocialService;
import com.ozalp.portfolio.dataAccess.SocialRepository;
import com.ozalp.portfolio.entities.Social;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SocialManager implements SocialService {

    private final SocialMapper mapper;
    private final SocialRepository repository;

    @Override
    public void add(CreateSocialRequest createSocialRequest) {
        repository.save(mapper.toEntity(createSocialRequest));
    }

    @Override
    public void upOrderNumber(int id) {
        Social social = findById(id);
        social.setOrderNumber(social.getOrderNumber() + 1);
        repository.save(social);
    }

    @Override
    public void downOrderNumber(int id) {
        Social social = findById(id);
        social.setOrderNumber(social.getOrderNumber() - 1);
        if (social.getOrderNumber() <= 1)
            social.setOrderNumber(1);
        repository.save(social);
    }

    @Override
    public void delete(int id) {
        var entity = findById(id);
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void setShowable(int id, Boolean value) {
        Social social = findById(id);
        social.setShowable(value);
        repository.save(social);
    }

    @Override
    public Social findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public List<SocialResponse> getSocials() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void update(int id, UpdateSocialRequest request) {
        var entity = findById(id);
        mapper.updateEntity(request, entity);
        repository.save(entity);
    }
}
