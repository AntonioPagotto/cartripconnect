package com.unifei.edu.br.carconnect.models;

import lombok.Data;

@Data
public class Carro {

    private String id;
    private String motoristaId;
    private String modelo;
    private String marca;
    private String placa;
    private String cor;
    private String ano;

}