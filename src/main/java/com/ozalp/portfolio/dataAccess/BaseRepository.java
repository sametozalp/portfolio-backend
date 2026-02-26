package com.ozalp.portfolio.dataAccess;

import com.ozalp.portfolio.entities.BaseEntity;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID extends Integer>
        extends JpaRepository<T, ID> {
}
