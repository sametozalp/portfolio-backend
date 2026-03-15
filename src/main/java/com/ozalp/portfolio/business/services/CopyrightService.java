package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.create.CreateCopyrightRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateCopyrightRequest;
import com.ozalp.portfolio.business.dtos.responses.CopyrightResponse;
import com.ozalp.portfolio.entities.Copyright;

public interface CopyrightService extends BaseService<Copyright> {

    CopyrightResponse getCopyright();

    void update(int id, UpdateCopyrightRequest request);

    void add(CreateCopyrightRequest createCopyrightRequest);


}
