package com.unifei.edu.br.carconnect.repository.impl;

import com.unifei.edu.br.carconnect.models.Corrida;
import com.unifei.edu.br.carconnect.repository.CorridaRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CorridaRepositoryImpl implements CorridaRepository {

  private final MongoOperations mongoOperations;

  public CorridaRepositoryImpl(final MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  @Override
  public String inserirCorrida(final Corrida corrida) {

    return mongoOperations.save(corrida, "corridas").getId();
  }

  @Override
  public List<Corrida> buscarTodosCorridas() {

    return mongoOperations.findAll(Corrida.class, "corridas");
  }

  @Override
  public List<Corrida> buscarCorridaPorMotoristaId(String id) {

    Query query = new Query();
    query.addCriteria(Criteria.where("motoristaId").is(id));

    return mongoOperations.find(query, Corrida.class, "corridas");
  }

  @Override
  public Corrida buscarCorridaPorId(String id) {

    return mongoOperations.findById(id, Corrida.class, "corridas");
  }

  @Override
  public String editarCorrida(final Corrida corrida) {

    return mongoOperations.save(corrida, "corridas").getId();
  }

  @Override
  public String apagarCorridaPorId(final String id){

    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(id));

    return mongoOperations.remove(query, Corrida.class, "corridas").toString();
  }

}