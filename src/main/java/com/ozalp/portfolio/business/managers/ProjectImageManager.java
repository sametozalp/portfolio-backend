package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.responses.ProjectImageResponse;
import com.ozalp.portfolio.business.services.ProjectImageService;
import com.ozalp.portfolio.dataAccess.ProjectImageRepository;
import com.ozalp.portfolio.entities.ProjectImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectImageManager implements ProjectImageService {

    private final ProjectImageRepository repository;

    @Override
    public void delete(int id) {
        var entity = repository.findById(id).orElseThrow();
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void add(ProjectImage projectImage) {
        repository.save(projectImage);
    }

    @Override
    public List<ProjectImageResponse> getProjectImages(int projectId) {
        return repository.findAll()
                .stream()
                .filter(r -> r.getId() == projectId)
                .map(r -> new ProjectImageResponse(r.getId(), r.getUrl()))
                .toList();
    }
}
