package com.unifei.edu.br.carconnect.repository.impl;

import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Motorista;
import com.unifei.edu.br.carconnect.models.Passageiro;
import com.unifei.edu.br.carconnect.repository.MotoristaRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotoristaRepositoryImpl implements MotoristaRepository {

  private final MongoOperations mongoOperations;

  public MotoristaRepositoryImpl(final MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  @Override
  public String inserirMotorista(final Motorista motorista) {

    return mongoOperations.save(motorista, "motoristas").getId();
  }

  @Override
  public List<Motorista> buscarTodosMotoristas() {

    return mongoOperations.findAll(Motorista.class, "motoristas");
  }

  @Override
  public Motorista buscarMotoristaPorId(String id) {

    return mongoOperations.findById(id, Motorista.class, "motoristas");
  }

  @Override
  public String editarMotorista(final Motorista motorista) {

    return mongoOperations.save(motorista, "motoristas").getId();
  }

  @Override
  public String apagarMotoristaPorId(final String id){

    return mongoOperations.remove(id).toString();
  }

  @Override
  public String loginMotorista(final Login login){

    Query query = new Query();
    query.addCriteria(Criteria.where("email").is(login.getEmail()).and("senha").is(login.getSenha()));

    Motorista motorista = mongoOperations.findOne(query, Motorista.class, "motoristas");
    return motorista.getId();
  }

}