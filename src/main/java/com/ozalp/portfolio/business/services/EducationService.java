package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.create.CreateEducationRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateEducationRequest;
import com.ozalp.portfolio.business.dtos.responses.EducationResponse;
import com.ozalp.portfolio.entities.Education;

import java.util.List;

public interface EducationService extends BaseService<Education> {

    List<EducationResponse> getEducations();

    void update(int id, UpdateEducationRequest request);

    void add(CreateEducationRequest createEducationRequest);
}
