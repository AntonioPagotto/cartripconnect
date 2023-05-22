package com.unifei.edu.br.carconnect.repository;

import com.unifei.edu.br.carconnect.models.Passageiro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassageiroRepository extends MongoRepository<Passageiro, String> {
    Optional<Passageiro> findById(String id);

    Passageiro save(Optional<Passageiro> existingPassageiro);
}