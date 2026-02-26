package com.ozalp.portfolio.business.dtos.requests.create;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class CreateExperienceRequest {

    private String positionName;

    private String description;

    private String company;

    private LocalDate startDate;

    private LocalDate endDate;


}
