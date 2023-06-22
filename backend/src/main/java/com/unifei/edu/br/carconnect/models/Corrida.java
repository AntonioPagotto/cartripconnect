package com.unifei.edu.br.carconnect.models;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class Corrida {

    private String id;
    private String motoristaId;
    private String origem;
    private String destino;
    private String data;
    private String carro;
    private List<String> passageiros = new ArrayList<>();
}