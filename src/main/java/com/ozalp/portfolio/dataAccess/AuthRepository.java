package com.ozalp.portfolio.dataAccess;

import com.ozalp.portfolio.entities.Auth;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends BaseRepository<Auth, Integer> {
    Optional<Auth> findByUsername(String username);
}
