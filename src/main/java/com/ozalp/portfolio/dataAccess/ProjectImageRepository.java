package com.ozalp.portfolio.dataAccess;

import com.ozalp.portfolio.entities.ProjectImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectImageRepository extends JpaRepository<ProjectImage, Integer> {
}
