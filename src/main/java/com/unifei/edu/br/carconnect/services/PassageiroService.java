package com.unifei.edu.br.carconnect.services;

import com.unifei.edu.br.carconnect.models.Passageiro;
import com.unifei.edu.br.carconnect.repository.PassageiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;

    public List<Passageiro> getAllPassageiros() {
        return passageiroRepository.buscarTodosPassageiros();
    }

    public Passageiro getPassageiroById(String id) {
        return passageiroRepository.buscarPassageiroPorId(id);
    }

    public String createPassageiro(Passageiro passageiro) {
        return passageiroRepository.inserirPassageiro(passageiro);
    }

    public String updatePassageiro(String id, Passageiro passageiro) {
        Passageiro existingPassageiro = passageiroRepository.buscarPassageiroPorId(id);
        if (existingPassageiro != null) {
            existingPassageiro.setNome(passageiro.getNome());
            existingPassageiro.setCpf(passageiro.getCpf());
            existingPassageiro.setRanking(passageiro.getRanking());
            existingPassageiro.setSenha(passageiro.getSenha());
            existingPassageiro.setMeioDePagamento(passageiro.getMeioDePagamento());

            return passageiroRepository.editarPassageiro(existingPassageiro);
        } else {
            return null;
        }
    }

    public void deletePassageiro(String id) {
        Passageiro passageiro = passageiroRepository.buscarPassageiroPorId(id);
        if (passageiro != null) {
            passageiroRepository.apagarPassageiroPorId(id);
        }
    }
}