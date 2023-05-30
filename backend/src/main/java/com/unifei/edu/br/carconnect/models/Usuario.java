package com.unifei.edu.br.carconnect.models;

import lombok.Data;

@Data
public abstract class Usuario {

    private String id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String telefone;
    private String ranking;

}
