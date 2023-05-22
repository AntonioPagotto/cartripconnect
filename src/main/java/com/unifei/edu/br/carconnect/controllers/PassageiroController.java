package com.unifei.edu.br.carconnect.controllers;

import com.unifei.edu.br.carconnect.models.Passageiro;
import com.unifei.edu.br.carconnect.services.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    @Autowired
    private PassageiroService passageiroService;

    @GetMapping
    public ResponseEntity<List<Passageiro>> getAllPassageiros() {
        List<Passageiro> passageiros = passageiroService.getAllPassageiros();
        return new ResponseEntity<>(passageiros, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passageiro> getPassageiroById(@PathVariable("id") String id) {
        Optional<Passageiro> passageiroOptional = passageiroService.getPassageiroById(id);
        if (passageiroOptional.isPresent()) {
            Passageiro passageiro = passageiroOptional.get();
            return new ResponseEntity<>(passageiro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Passageiro> createPassageiro(@RequestBody Passageiro passageiro) {
        Passageiro createdPassageiro = passageiroService.createPassageiro(passageiro);
        return new ResponseEntity<>(createdPassageiro, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Passageiro> updatePassageiro(@PathVariable("id") String id, @RequestBody Passageiro passageiro) {
        Passageiro updatedPassageiro = passageiroService.updatePassageiro(id, passageiro);
        if (updatedPassageiro != null) {
            return new ResponseEntity<>(updatedPassageiro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassageiro(@PathVariable("id") String id) {
        passageiroService.deletePassageiro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}