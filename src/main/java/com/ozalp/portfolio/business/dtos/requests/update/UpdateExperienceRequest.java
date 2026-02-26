package com.ozalp.portfolio.business.dtos.requests.update;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class UpdateExperienceRequest {

    private String positionName;

    private String description;

    private String company;

    private LocalDate startDate;

    private LocalDate endDate;


}
