package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.responses.ProjectImageResponse;
import com.ozalp.portfolio.entities.Project;
import com.ozalp.portfolio.entities.ProjectImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProjectImageService extends BaseService<ProjectImage> {

    void delete(int id);

    void add(ProjectImage projectImage);

    List<ProjectImageResponse> getProjectImages(int projectId);

    void add(Project saved, List<MultipartFile> images);

    void upOrderNumber(int id);

    void downOrderNumber(int id);

    void setCoverImage(int id);
}
