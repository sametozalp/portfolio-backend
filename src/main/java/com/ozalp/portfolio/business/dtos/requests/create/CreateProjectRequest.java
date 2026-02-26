package com.ozalp.portfolio.business.dtos.requests.create;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
@Getter
@Setter
public class CreateProjectRequest {

    private String title;

    private String summary;

    private String description;

    private List<String> features;

//    private List<String> images;

    private LocalDate projectDate;

    private List<String> techStack;

    private String liveDemoUrl;

    private String sourceCodeUrl;

    private String coverImage;


}
