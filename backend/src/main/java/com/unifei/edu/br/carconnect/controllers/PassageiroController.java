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
    public ResponseEntity<String> createPassageiro(@RequestBody Passageiro passageiro) {
        String id = passageiroService.createPassageiro(passageiro);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePassageiro(@PathVariable String id, @RequestBody Passageiro passageiro) {
        String result = passageiroService.updatePassageiro(id, passageiro);
        if (result != null) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassageiro(@PathVariable String id) {
        passageiroService.deletePassageiro(id);
        return ResponseEntity.noContent().build();
    }
}