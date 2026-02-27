package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.responses.ProjectImageResponse;
import com.ozalp.portfolio.entities.ProjectImage;

import java.util.List;

public interface ProjectImageService {

    void delete(int id);

    void add(ProjectImage projectImage);

    List<ProjectImageResponse> getProjectImages(int projectId);
}
