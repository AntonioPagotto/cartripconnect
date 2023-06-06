package com.unifei.edu.br.carconnect.repository.impl;

import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Carro;
import com.unifei.edu.br.carconnect.repository.CarroRepository;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarroRepositoryImpl implements CarroRepository {

  private final MongoOperations mongoOperations;

  public CarroRepositoryImpl(final MongoOperations mongoOperations) {
    this.mongoOperations = mongoOperations;
  }

  @Override
  public String inserirCarro(final Carro carro) {

    return mongoOperations.save(carro, "carros").getId();
  }

  @Override
  public List<Carro> buscarTodosCarros() {

    return mongoOperations.findAll(Carro.class, "carros");
  }

  @Override
  public List<Carro> buscarCarroPorMotoristaId(String id) {

    Query query = new Query();
    query.addCriteria(Criteria.where("motoristaId").is(id));

    return mongoOperations.find(query, Carro.class, "carros");
  }

  @Override
  public Carro buscarCarroPorId(String id) {

    return mongoOperations.findById(id, Carro.class, "carros");
  }

  @Override
  public String editarCarro(final Carro carro) {

    return mongoOperations.save(carro, "carros").getId();
  }

  @Override
  public String apagarCarroPorId(final String id){

    Query query = new Query();
    query.addCriteria(Criteria.where("_id").is(id));

    return mongoOperations.remove(query, Carro.class, "carros").toString();
  }

}