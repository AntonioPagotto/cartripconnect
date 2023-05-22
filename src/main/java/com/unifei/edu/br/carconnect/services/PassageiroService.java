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
        return passageiroRepository.findAll();
    }

    public Optional<Passageiro> getPassageiroById(String id) {
        return passageiroRepository.findById(id);
    }

    public Passageiro createPassageiro(Passageiro passageiro) {
        return passageiroRepository.save(passageiro);
    }

    public Passageiro updatePassageiro(String id, Passageiro passageiro) {
        Optional<Passageiro> existingPassageiro = passageiroRepository.findById(id);
        if (existingPassageiro.isPresent()) {
            existingPassageiro.get().setNome(passageiro.getNome());
            existingPassageiro.get().setCpf(passageiro.getCpf());
            existingPassageiro.get().setRanking(passageiro.getRanking());
            existingPassageiro.get().setSenha(passageiro.getSenha());
            existingPassageiro.get().setMeioDePagamento(passageiro.getMeioDePagamento());

            return passageiroRepository.save(existingPassageiro);
        } else {
            return null;
        }
    }

    public void deletePassageiro(String id) {
        Optional<Passageiro> passageiro = passageiroRepository.findById(id);
        if (passageiro.isPresent()) {
            passageiroRepository.deleteById(id);
        }
    }
}