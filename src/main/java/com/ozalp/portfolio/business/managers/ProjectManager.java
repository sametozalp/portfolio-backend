package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateProjectRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateProjectRequest;
import com.ozalp.portfolio.business.dtos.responses.ProjectResponse;
import com.ozalp.portfolio.business.mappers.ProjectMapper;
import com.ozalp.portfolio.business.services.ProjectImageService;
import com.ozalp.portfolio.business.services.ProjectService;
import com.ozalp.portfolio.dataAccess.ProjectRepository;
import com.ozalp.portfolio.entities.Project;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectManager implements ProjectService {

    private final ProjectRepository repository;
    private final ProjectMapper mapper;
    private final ProjectImageService projectImageService;

    @Override
    public void add(CreateProjectRequest createProjectRequest) {
        repository.save(mapper.toEntity(createProjectRequest));
    }

    @Override
    public void delete(int id) {
        var entity = findById(id);
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void setShowable(int id, Boolean value) {
        Project project = findById(id);
        project.setShowable(value);
        repository.save(project);
    }

    @Override
    public Project findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

    @Override
    public List<ProjectResponse> getProjects() {
        return repository.findAll()
                .stream()
                .map(mapper::toResponse)
                .toList();
    }

    @Override
    public void update(int id, UpdateProjectRequest request) {
        var entity = findById(id);
        mapper.updateEntity(request, entity);
        repository.save(entity);
    }

    @Transactional
    @Override
    public void add(CreateProjectRequest request, List<MultipartFile> images) {
        Project saved = repository.save(mapper.toEntity(request));
        projectImageService.add(saved, images);
    }
}
