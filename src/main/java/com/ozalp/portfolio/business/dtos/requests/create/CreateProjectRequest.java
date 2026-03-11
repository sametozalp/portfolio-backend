package com.ozalp.portfolio.business.dtos.requests.create;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CreateProjectRequest {

    private String title;

    private String summary;

    private String description;

    private String features;

    private LocalDate projectDate;

    private String techStack;

    private String liveDemoUrl;

    private String sourceCodeUrl;
}
