package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.create.CreateAboutRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateAboutRequest;
import com.ozalp.portfolio.business.dtos.responses.AboutResponse;
import com.ozalp.portfolio.entities.About;

public interface AboutService extends BaseService<About> {

    AboutResponse getAbout();

    void update(int id, UpdateAboutRequest request);

    void add(CreateAboutRequest createAboutRequest);
}
