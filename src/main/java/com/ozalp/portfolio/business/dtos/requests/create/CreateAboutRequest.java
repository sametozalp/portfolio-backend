package com.ozalp.portfolio.business.dtos.requests.create;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateAboutRequest {

    private String description;

    private String profileImageUrl;

    private List<String> skills;


}
