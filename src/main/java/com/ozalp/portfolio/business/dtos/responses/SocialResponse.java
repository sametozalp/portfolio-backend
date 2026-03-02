package com.ozalp.portfolio.business.dtos.responses;

import com.ozalp.portfolio.business.enums.SocialMedia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocialResponse {

    private int id;

    private SocialMedia type;

    private String url;
}
