package com.ozalp.portfolio.business.dtos.requests.create;

import com.ozalp.portfolio.business.enums.Platform;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateSocialRequest {

    private Platform platform;

    private String url;
}
