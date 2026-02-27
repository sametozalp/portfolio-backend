package com.ozalp.portfolio.dataAccess;

import com.ozalp.portfolio.business.dtos.responses.ProfileImageResponse;
import com.ozalp.portfolio.entities.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, Integer> {
    ProfileImage findByIsProfileImageIsTrue();
}
