package com.ozalp.portfolio.business.dtos.requests.update;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAboutRequest {

    private String description;

    private String profileImageUrl;

    private String skills;

    private String title;

}
