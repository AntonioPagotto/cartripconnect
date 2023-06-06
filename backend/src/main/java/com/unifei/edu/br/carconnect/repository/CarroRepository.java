package com.unifei.edu.br.carconnect.repository;

import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Carro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository {
    String inserirCarro(final Carro Carro);

    List<Carro> buscarTodosCarros();

    List<Carro> buscarCarroPorMotoristaId(final String id);

    Carro buscarCarroPorId(final String id);

    String editarCarro(final Carro carro);
    String apagarCarroPorId(final String id);

}