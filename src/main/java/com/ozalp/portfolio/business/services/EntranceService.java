package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.create.CreateEntranceRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateEntranceRequest;
import com.ozalp.portfolio.business.dtos.responses.EntranceResponse;
import com.ozalp.portfolio.entities.Entrance;

public interface EntranceService extends BaseService<Entrance> {

    EntranceResponse getEntrance();

    void update(int id, UpdateEntranceRequest request);

    void add(CreateEntranceRequest createEntranceRequest);
}
