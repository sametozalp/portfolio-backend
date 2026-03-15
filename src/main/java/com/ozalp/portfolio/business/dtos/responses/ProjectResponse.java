package com.ozalp.portfolio.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ProjectResponse {

    private int id;

    private String title;

    private String summary;

    private String description;

    private String features;

    private LocalDate projectDate;

    private String techStack;

    private String liveDemoUrl;

    private String sourceCodeUrl;

    private List<ProjectImageResponse> images;

}
