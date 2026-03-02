package com.ozalp.portfolio.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AboutResponse {

    private int id;

    private String description;

    private String profileImageUrl;

    private List<String> skills;

    private String title;


}
