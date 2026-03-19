package com.ozalp.portfolio.business.managers;

import com.ozalp.portfolio.business.dtos.requests.LoginRequest;
import com.ozalp.portfolio.business.dtos.requests.create.CreateAuthRequest;
import com.ozalp.portfolio.business.enums.Role;
import com.ozalp.portfolio.business.mappers.AuthMapper;
import com.ozalp.portfolio.business.services.AuthService;
import com.ozalp.portfolio.dataAccess.AuthRepository;
import com.ozalp.portfolio.entities.Auth;
import com.ozalp.portfolio.security.JwtService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthManager implements AuthService {

    private final AuthRepository repository;
    private final AuthMapper mapper;
    private final JwtService jwtService;

    @Override
    public void add(CreateAuthRequest createAuthRequest) {
        repository.save(mapper.toEntity(createAuthRequest));
    }

    @Override
    public String login(LoginRequest request) {
        Auth given = repository.findByUsername(request.getUsername()).orElseThrow();

        if (!given.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Don't matches user info");
        }

        return jwtService.generateAccessToken(given);
    }

    @Override
    public void createRootAdmin() {
        Optional<Auth> username = repository.findByUsername("sametozalp");
        if (!username.isPresent()) {
            repository.save(new Auth("sametozalp", "sametozalpbusiness@gmail.com", "123456", Role.ADMIN));
        }
    }

    @Override
    public void validateToken(String token) {
        if (!jwtService.isTokenExpired(token)) {
            throw new RuntimeException("Invalid token");
        }
    }

    @Override
    public void delete(int id) {
        var entity = findById(id);
        entity.markAsDeleted();
        repository.save(entity);

    }

    @Override
    public void setShowable(int id, Boolean value) {
        Auth auth = findById(id);
        auth.setShowable(value);
        repository.save(auth);
    }

    @Override
    public Auth findById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found"));
    }

}
