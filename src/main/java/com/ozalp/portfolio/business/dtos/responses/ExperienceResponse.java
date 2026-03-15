package com.ozalp.portfolio.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class ExperienceResponse {

    private int id;

    private String positionName;

    private String description;

    private String company;

    private LocalDate startDate;

    private LocalDate endDate;

    private Boolean showable;

}
