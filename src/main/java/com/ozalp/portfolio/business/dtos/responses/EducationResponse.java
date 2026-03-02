package com.ozalp.portfolio.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class EducationResponse {

    private int id;

    private String major;

    private String description;

    private String school;

    private LocalDate startDate;

    private LocalDate endDate;
}
