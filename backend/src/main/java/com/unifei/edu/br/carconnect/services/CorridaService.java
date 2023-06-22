package com.unifei.edu.br.carconnect.services;

import com.unifei.edu.br.carconnect.models.Corrida;
import com.unifei.edu.br.carconnect.models.CorridaPassageiro;
import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.repository.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CorridaService {

    @Autowired
    private CorridaRepository corridaRepository;

    public List<Corrida> getAllCorridas() {
        LocalDateTime dataAtual = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        List<Corrida> corridasAnterioresAmanha = new ArrayList<>();
        List<Corrida> corridas = corridaRepository.buscarTodosCorridas();

        for (Corrida corrida : corridas) {
            LocalDateTime dataCorrida = LocalDateTime.parse(corrida.getData(), formatter);

            if (dataCorrida.isAfter(dataAtual)) {
                corridasAnterioresAmanha.add(corrida);
            }
        }
        return corridasAnterioresAmanha;
    }

    public List<Corrida> getCorridaByMotoristaId(String id) {
        return corridaRepository.buscarCorridaPorMotoristaId(id);
    }

    public Corrida getCorridaById(String id) {
        return corridaRepository.buscarCorridaPorId(id);
    }

    public String createCorrida(Corrida corrida) {
        return corridaRepository.inserirCorrida(corrida);
    }

    public String updateCorrida(String id, Corrida carro) {
        Corrida existingCorrida = corridaRepository.buscarCorridaPorId(id);
        if (existingCorrida != null) {
            existingCorrida.setMotoristaId(carro.getMotoristaId());
            existingCorrida.setOrigem(carro.getOrigem());
            existingCorrida.setDestino(carro.getDestino());

            return corridaRepository.editarCorrida(existingCorrida);
        } else {
            return null;
        }
    }

    public void deleteCorrida(String id) {
        Corrida carro = corridaRepository.buscarCorridaPorId(id);
        if (carro != null) {
            corridaRepository.apagarCorridaPorId(id);
        }
    }

    public String adicionarOuRemoverPassageiro(CorridaPassageiro corridaPassageiro){

        Corrida corrida = corridaRepository.buscarCorridaPorId(corridaPassageiro.getCorridaId());

        if (corrida.getPassageiros().contains(corridaPassageiro.getPassageiroId())) {
            corrida.getPassageiros().remove(corridaPassageiro.getPassageiroId());
        } else {
            corrida.getPassageiros().add(corridaPassageiro.getPassageiroId());
        }
        return corridaRepository.editarCorrida(corrida);
    }

}