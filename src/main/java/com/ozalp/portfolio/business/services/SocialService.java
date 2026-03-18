package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.create.CreateSocialRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateSocialRequest;
import com.ozalp.portfolio.business.dtos.responses.SocialResponse;
import com.ozalp.portfolio.entities.Social;

import java.util.List;

public interface SocialService extends BaseService<Social> {

    List<SocialResponse> getSocials();

    void update(int id, UpdateSocialRequest request);

    void add(CreateSocialRequest createSocialRequest);

    void upOrderNumber(int id);

    void downOrderNumber(int id);

    SocialResponse getSocial(int id);
}
