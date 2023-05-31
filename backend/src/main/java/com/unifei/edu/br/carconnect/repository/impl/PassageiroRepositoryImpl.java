package com.unifei.edu.br.carconnect.repository.impl;

import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Motorista;
import com.unifei.edu.br.carconnect.models.Passageiro;
import com.unifei.edu.br.carconnect.repository.PassageiroRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PassageiroRepositoryImpl implements PassageiroRepository {

  private final MongoOperations mongoOperations;

  public PassageiroRepositoryImpl(final MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  @Override
  public String inserirPassageiro(final Passageiro passageiro) {

    return mongoOperations.save(passageiro, "passageiros").getId();
  }

  @Override
  public List<Passageiro> buscarTodosPassageiros() {

    return mongoOperations.findAll(Passageiro.class, "passageiros");
  }

  @Override
  public Passageiro buscarPassageiroPorId(String id) {

    return mongoOperations.findById(id, Passageiro.class, "passageiros");
  }

  @Override
  public String editarPassageiro(final Passageiro passageiro) {

    return mongoOperations.save(passageiro, "passageiros").getId();
  }

  @Override
  public String apagarPassageiroPorId(final String id){

    return mongoOperations.remove(id).toString();
  }

  @Override
  public String loginPassageiro(final Login login){

    Query query = new Query();
    query.addCriteria(Criteria.where("email").is(login.getEmail()).and("senha").is(login.getSenha()));

    Passageiro passageiro = mongoOperations.findOne(query, Passageiro.class, "passageiros");
    return passageiro.getId();
  }


}