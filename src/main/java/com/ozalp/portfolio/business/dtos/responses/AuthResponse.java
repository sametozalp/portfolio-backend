package com.ozalp.portfolio.business.dtos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponse {

    private int id;

    private String username;

    private String email;

    private String password;

}
