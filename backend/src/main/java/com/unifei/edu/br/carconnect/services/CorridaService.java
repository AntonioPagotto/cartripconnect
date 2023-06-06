package com.unifei.edu.br.carconnect.services;

import com.unifei.edu.br.carconnect.models.Corrida;
import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.repository.CorridaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CorridaService {

    @Autowired
    private CorridaRepository carroRepository;

    public List<Corrida> getAllCorridas() {
        return carroRepository.buscarTodosCorridas();
    }

    public List<Corrida> getCorridaByMotoristaId(String id) {
        return carroRepository.buscarCorridaPorMotoristaId(id);
    }

    public String createCorrida(Corrida carro) {
        return carroRepository.inserirCorrida(carro);
    }

    public String updateCorrida(String id, Corrida carro) {
        Corrida existingCorrida = carroRepository.buscarCorridaPorId(id);
        if (existingCorrida != null) {
            existingCorrida.setMotoristaId(carro.getMotoristaId());
            existingCorrida.setOrigem(carro.getOrigem());
            existingCorrida.setDestino(carro.getDestino());

            return carroRepository.editarCorrida(existingCorrida);
        } else {
            return null;
        }
    }

    public void deleteCorrida(String id) {
        Corrida carro = carroRepository.buscarCorridaPorId(id);
        if (carro != null) {
            carroRepository.apagarCorridaPorId(id);
        }
    }

}