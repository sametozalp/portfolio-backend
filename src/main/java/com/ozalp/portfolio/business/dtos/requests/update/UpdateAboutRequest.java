package com.ozalp.portfolio.business.dtos.requests.update;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UpdateAboutRequest {

    private String description;

    private String profileImageUrl;

    private List<String> skills;

    private String title;

}
