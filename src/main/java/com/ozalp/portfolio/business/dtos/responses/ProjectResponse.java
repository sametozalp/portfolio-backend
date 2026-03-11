package com.ozalp.portfolio.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProjectResponse {

    private String title;

    private String summary;

    private String description;

    private String features;

    private LocalDate projectDate;

    private String techStack;

    private String liveDemoUrl;

    private String sourceCodeUrl;

}
