package com.guilhermecamara.taskapi.model;

import java.io.Serializable;

public class JWTResponse implements Serializable {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwtToken;

    public JWTResponse(String jwtToken){
        this.jwtToken = jwtToken;
    }

    public String getJwtToken() {
        return jwtToken;
    }
}
