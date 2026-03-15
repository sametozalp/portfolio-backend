package com.ozalp.portfolio.business.services;

import com.ozalp.portfolio.entities.BaseEntity;

public interface BaseService<T extends BaseEntity> {

    void delete(int id);

    void setShowable(int id, Boolean value);

    T findById(int id);
}
