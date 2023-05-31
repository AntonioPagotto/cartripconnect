package com.unifei.edu.br.carconnect.services;

import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Motorista;
import com.unifei.edu.br.carconnect.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;

    public List<Motorista> getAllMotoristas() {
        return motoristaRepository.buscarTodosMotoristas();
    }

    public Motorista getMotoristaById(String id) {
        return motoristaRepository.buscarMotoristaPorId(id);
    }

    public String createMotorista(Motorista motorista) {
        return motoristaRepository.inserirMotorista(motorista);
    }

    public String updateMotorista(String id, Motorista motorista) {
        Motorista existingMotorista = motoristaRepository.buscarMotoristaPorId(id);
        if (existingMotorista != null) {
            existingMotorista.setNome(motorista.getNome());
            existingMotorista.setCpf(motorista.getCpf());
            existingMotorista.setEmail(motorista.getEmail());
            existingMotorista.setTelefone(motorista.getTelefone());
            return motoristaRepository.editarMotorista(existingMotorista);
        } else {
            return null;
        }
    }

    public void deleteMotorista(String id) {
        Motorista motorista = motoristaRepository.buscarMotoristaPorId(id);
        if (motorista != null) {
            motoristaRepository.apagarMotoristaPorId(id);
        }
    }

    public String loginMotorista(Login login) {
        return motoristaRepository.loginMotorista(login);
    }
}