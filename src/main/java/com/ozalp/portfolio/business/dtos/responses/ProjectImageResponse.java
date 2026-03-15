package com.ozalp.portfolio.business.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectImageResponse {

    private int id;

    private String url;

    private Boolean isCoverImage;

    private int orderNumber;

    private Boolean showable;

}
