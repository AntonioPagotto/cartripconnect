package com.unifei.edu.br.carconnect.services;

import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Carro;
import com.unifei.edu.br.carconnect.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<Carro> getAllCarros() {
        return carroRepository.buscarTodosCarros();
    }

    public List<Carro> getCarroByMotoristaId(String id) {
        return carroRepository.buscarCarroPorMotoristaId(id);
    }

    public String createCarro(Carro carro) {
        return carroRepository.inserirCarro(carro);
    }

    public String updateCarro(String id, Carro carro) {
        Carro existingCarro = carroRepository.buscarCarroPorId(id);
        if (existingCarro != null) {
            existingCarro.setMotoristaId(carro.getMotoristaId());
            existingCarro.setModelo(carro.getModelo());
            existingCarro.setMarca(carro.getMarca());
            existingCarro.setPlaca(carro.getPlaca());
            existingCarro.setCor(carro.getCor());
            existingCarro.setAno(carro.getAno());

            return carroRepository.editarCarro(existingCarro);
        } else {
            return null;
        }
    }

    public void deleteCarro(String id) {
        Carro carro = carroRepository.buscarCarroPorId(id);
        if (carro != null) {
            carroRepository.apagarCarroPorId(id);
        }
    }

}