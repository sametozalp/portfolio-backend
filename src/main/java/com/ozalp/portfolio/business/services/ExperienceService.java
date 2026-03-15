package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.create.CreateExperienceRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateExperienceRequest;
import com.ozalp.portfolio.business.dtos.responses.ExperienceResponse;
import com.ozalp.portfolio.entities.Experience;

import java.util.List;

public interface ExperienceService extends BaseService<Experience> {

    List<ExperienceResponse> getExperience();

    void update(int id, UpdateExperienceRequest request);

    void add(CreateExperienceRequest createExperienceRequest);

}
