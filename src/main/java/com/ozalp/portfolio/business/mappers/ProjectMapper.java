package com.ozalp.portfolio.business.mappers;

import com.ozalp.portfolio.business.dtos.requests.create.CreateProjectRequest;
import com.ozalp.portfolio.business.dtos.requests.update.UpdateProjectRequest;
import com.ozalp.portfolio.business.dtos.responses.ProjectResponse;
import com.ozalp.portfolio.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper<Project, CreateProjectRequest, ProjectResponse> {

    void updateEntity(UpdateProjectRequest request, @MappingTarget Project entity);

}