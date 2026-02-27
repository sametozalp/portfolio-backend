package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.responses.ProfileImageResponse;
import com.ozalp.portfolio.entities.ProfileImage;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProfileImageService {

    void delete(int id);

    void add(ProfileImage profileImage);

    List<ProfileImageResponse> getAll();

    ProfileImageResponse getProfileImage();

    void change(MultipartFile image);
}
