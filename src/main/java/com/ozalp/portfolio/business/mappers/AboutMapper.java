package com.ozalp.portfolio.business.mappers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateAboutRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateAboutRequest;
import com.ozalp.portfolio.business.dtos.responses.AboutResponse;
import com.ozalp.portfolio.entities.About;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AboutMapper extends BaseMapper<About, CreateAboutRequest, AboutResponse> {

    void updateEntity(UpdateAboutRequest request, @MappingTarget About entity);

}
