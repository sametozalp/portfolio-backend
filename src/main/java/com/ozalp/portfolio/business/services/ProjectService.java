package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.create.CreateProjectRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateProjectRequest;
import com.ozalp.portfolio.business.dtos.responses.ProjectResponse;
import com.ozalp.portfolio.entities.Project;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectService extends BaseService<Project> {

    List<ProjectResponse> getProjects();

    void update(int id, UpdateProjectRequest request);

    void add(CreateProjectRequest request, List<MultipartFile> images);

    ProjectResponse getProject(int id);

    void add(CreateProjectRequest createProjectRequest);
}
