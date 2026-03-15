package com.ozalp.portfolio.business.managers;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import com.ozalp.portfolio.business.dtos.responses.ProfileImageResponse;
import com.ozalp.portfolio.business.services.ProfileImageService;
import com.ozalp.portfolio.dataAccess.ProfileImageRepository;
import com.ozalp.portfolio.entities.ProfileImage;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class ProfileImageManager implements ProfileImageService {

    private final ProfileImageRepository repository;

    @Override
    public void delete(int id) {
        var entity = repository.findById(id).orElseThrow();
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void setShowable(int id, Boolean value) {
        ProfileImage profileImage = findById(id);
        profileImage.setShowable(value);
        repository.save(profileImage);
    }

    @Override
    public ProfileImage findById(int id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void add(ProfileImage profileImage) {

        List<ProfileImage> all = repository.findAll();
        all.stream().forEach(p -> {
            p.markAsDeleted();
            repository.save(p);
        });

        repository.save(profileImage);
    }

    @SneakyThrows
    @Override
    public void add(MultipartFile image) {
        String fileName = UUID.randomUUID() + "-" + LocalDateTime.now();

        Bucket bucket = StorageClient.getInstance().bucket();

        Blob blob = bucket.create(
                "profile-images/" + fileName,
                image.getBytes(),
                image.getContentType()
        );

        URL url = blob.signUrl(3650, TimeUnit.DAYS); // 10 years

        String uploadedImageLink = url.toString();

        List<ProfileImage> all = repository.findAll();
        all.stream().forEach(p -> {
            p.markAsDeleted();
            repository.save(p);
        });

        repository.save(new ProfileImage(uploadedImageLink));
    }

    @Override
    public List<ProfileImageResponse> getAll() {
        return repository
                .findAll()
                .stream()
                .map(r -> new ProfileImageResponse(
                        r.getId(), r.getUrl()
                ))
                .toList();
    }

    @Override
    public ProfileImageResponse getProfileImage() {
        Optional<ProfileImage> profileImage = repository.findAll().stream().findFirst();
        return profileImage.map(image -> new ProfileImageResponse(image.getId(), image.getUrl()))
                .orElse(null);
    }
}
