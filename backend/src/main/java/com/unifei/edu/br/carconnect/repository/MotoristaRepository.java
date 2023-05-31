package com.unifei.edu.br.carconnect.repository;

import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Motorista;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoristaRepository {
    String inserirMotorista(final Motorista motorista);

    List<Motorista> buscarTodosMotoristas();

    Motorista buscarMotoristaPorId(final String id);

    String editarMotorista(final Motorista motorista);
    String apagarMotoristaPorId(final String id);

    String loginMotorista(final Login login);

}