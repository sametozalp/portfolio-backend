package com.ozalp.portfolio.business.dtos.requests.update;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class UpdateProjectRequest {

    private String title;

    private String summary;

    private String description;

    private String features;

    private LocalDate projectDate;

    private String techStack;

    private String liveDemoUrl;

    private String sourceCodeUrl;


}
