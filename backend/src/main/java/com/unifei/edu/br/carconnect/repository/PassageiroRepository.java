package com.unifei.edu.br.carconnect.repository;

import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Passageiro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassageiroRepository{
    String inserirPassageiro(final Passageiro passageiro);

    List<Passageiro> buscarTodosPassageiros();

    Passageiro buscarPassageiroPorId(final String id);

    String editarPassageiro(final Passageiro passageiro);
    String apagarPassageiroPorId(final String id);

    String loginPassageiro(final Login login);

}