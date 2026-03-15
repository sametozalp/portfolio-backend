package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.create.CreateAuthRequest;
import com.ozalp.portfolio.entities.Auth;

public interface AuthService extends BaseService<Auth> {

    void add(CreateAuthRequest createAuthRequest);
}
