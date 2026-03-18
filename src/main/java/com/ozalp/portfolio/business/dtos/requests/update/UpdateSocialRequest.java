package com.ozalp.portfolio.business.dtos.requests.update;

import com.ozalp.portfolio.business.enums.Platform;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSocialRequest {

    private Platform platform;

    private String url;
}
