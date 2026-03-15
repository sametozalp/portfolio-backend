package com.ozalp.portfolio.business.managers;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import com.ozalp.portfolio.business.dtos.responses.ProjectImageResponse;
import com.ozalp.portfolio.business.services.ProjectImageService;
import com.ozalp.portfolio.dataAccess.ProjectImageRepository;
import com.ozalp.portfolio.entities.Project;
import com.ozalp.portfolio.entities.ProjectImage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

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
                .map(r -> new ProjectImageResponse(r.getId(), r.getUrl(), r.getIsCoverImage(), r.getOrderNumber()))
                .toList();
    }

    @Override
    public void add(Project saved, List<MultipartFile> images) {
        Bucket bucket = StorageClient.getInstance().bucket();

        images.forEach(file -> {
            uploadToBucketAndSave(saved, bucket, file);
        });
    }

    @SneakyThrows
    private void uploadToBucketAndSave(Project saved, Bucket bucket, MultipartFile file) {
        String fileName = saved.getTitle() + "-" + UUID.randomUUID();

        Blob blob = bucket.create(
                "project-images/" + fileName,
                file.getBytes(),
                file.getContentType()
        );

        URL url = blob.signUrl(3650, TimeUnit.DAYS);
        repository.save(new ProjectImage(saved, url.toString()));
    }
}
