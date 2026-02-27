package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.services.ProfileImageService;
import com.ozalp.portfolio.dataAccess.ProfileImageRepository;
import com.ozalp.portfolio.entities.ProfileImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProfileImageManager implements ProfileImageService {

    private final ProfileImageRepository repository;

    @Override
    public void add(ProfileImage profileImage) {

    }
}
