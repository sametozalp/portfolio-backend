package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.business.dtos.requests.LoginRequest;
import com.ozalp.portfolio.business.dtos.requests.create.CreateAuthRequest;
import com.ozalp.portfolio.entities.Auth;
import jakarta.validation.Valid;

public interface AuthService extends BaseService<Auth> {

    void add(CreateAuthRequest createAuthRequest);

    String login(@Valid LoginRequest request);

    void createRootAdmin();
}
