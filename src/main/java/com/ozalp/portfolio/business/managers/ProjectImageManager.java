package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.services.ProjectImageService;
import com.ozalp.portfolio.dataAccess.ProjectImageRepository;
import com.ozalp.portfolio.entities.ProjectImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectImageManager implements ProjectImageService {

    private final ProjectImageRepository repository;

    @Override
    public void add(ProjectImage projectImage) {

    }
}
