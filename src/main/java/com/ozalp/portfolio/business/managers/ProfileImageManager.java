package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.responses.ProfileImageResponse;
import com.ozalp.portfolio.business.services.ProfileImageService;
import com.ozalp.portfolio.dataAccess.ProfileImageRepository;
import com.ozalp.portfolio.entities.ProfileImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileImageManager implements ProfileImageService {

    private final ProfileImageRepository repository;

    @Override
    public void add(ProfileImage profileImage) {
        repository.save(profileImage);
    }

    @Override
    public List<ProfileImageResponse> getAll() {
        return repository
                .findAll()
                .stream()
                .map(r -> new ProfileImageResponse(
                        r.getId(), r.getIsProfileImage(), r.getUrl()
                ))
                .toList();
    }

    @Override
    public ProfileImageResponse getProfileImage() {
        ProfileImage profileImage = repository.findByIsProfileImageIsTrue();
        return new ProfileImageResponse(profileImage.getId(), profileImage.getIsProfileImage(), profileImage.getUrl());
    }

    @Override
    public void change(MultipartFile image) {
        List<ProfileImage> list = repository.findAll()
                .stream()
                .filter(r -> r.getIsProfileImage() == true)
                .toList();

        list.stream().forEach(r->r.setIsProfileImage(false));

        repository.saveAll(list);

        // upload operations

    }
}
