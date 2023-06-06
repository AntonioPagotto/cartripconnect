package com.unifei.edu.br.carconnect.controllers;

import com.unifei.edu.br.carconnect.models.IdResponse;
import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Passageiro;
import com.unifei.edu.br.carconnect.services.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    private final PassageiroService passageiroService;

    public PassageiroController(PassageiroService passageiroService) {
        this.passageiroService = passageiroService;
    }

    @GetMapping
    public ResponseEntity<List<Passageiro>> getAllPassageiros() {
        List<Passageiro> passageiros = passageiroService.getAllPassageiros();
        return ResponseEntity.ok(passageiros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Passageiro> getPassageiroById(@PathVariable String id) {
        Passageiro passageiro = passageiroService.getPassageiroById(id);
        if (passageiro != null) {
            return ResponseEntity.ok(passageiro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<IdResponse> createPassageiro(@RequestBody Passageiro passageiro) {

        IdResponse response = new IdResponse(passageiroService.createPassageiro(passageiro));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IdResponse> updatePassageiro(@PathVariable String id, @RequestBody Passageiro passageiro) {
        String result = passageiroService.updatePassageiro(id, passageiro);
        if (result != null) {
            IdResponse response = new IdResponse(result);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassageiro(@PathVariable String id) {
        passageiroService.deletePassageiro(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<IdResponse> loginPassageiro(@RequestBody Login login) {


        IdResponse response = new IdResponse(passageiroService.loginPassageiro(login));

        return ResponseEntity.ok(response);
    }
}