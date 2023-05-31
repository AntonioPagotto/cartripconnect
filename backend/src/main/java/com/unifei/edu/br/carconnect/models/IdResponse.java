package com.unifei.edu.br.carconnect.models;

import lombok.Data;

@Data
public class IdResponse {

    private String id;

    public IdResponse(String id) {
        this.id = id;
    }
}
