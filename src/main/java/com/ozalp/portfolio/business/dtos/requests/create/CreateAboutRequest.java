package com.ozalp.portfolio.business.dtos.requests.create;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateAboutRequest {

    private String description;

    private String profileImageUrl;

    private String skills;

    private String title;

}
