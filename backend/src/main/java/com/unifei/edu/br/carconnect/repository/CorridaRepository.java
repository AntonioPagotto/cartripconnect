package com.unifei.edu.br.carconnect.repository;

import com.unifei.edu.br.carconnect.models.Corrida;
import com.unifei.edu.br.carconnect.models.Login;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CorridaRepository {
    String inserirCorrida(final Corrida Corrida);

    List<Corrida> buscarTodosCorridas();

    List<Corrida> buscarCorridaPorMotoristaId(final String id);

    Corrida buscarCorridaPorId(final String id);

    String editarCorrida(final Corrida corrida);
    String apagarCorridaPorId(final String id);

}