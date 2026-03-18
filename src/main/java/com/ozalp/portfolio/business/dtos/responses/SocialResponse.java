package com.ozalp.portfolio.business.dtos.responses;

import com.ozalp.portfolio.business.enums.Platform;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialResponse {

    private int id;

    private Platform platform;

    private String url;

    private int orderNumber;

    private Boolean showable;
}
