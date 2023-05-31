package com.unifei.edu.br.carconnect.controllers;

import com.unifei.edu.br.carconnect.models.IdResponse;
import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Motorista;
import com.unifei.edu.br.carconnect.services.MotoristaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    private final MotoristaService motoristaService;

    public MotoristaController(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @GetMapping
    public ResponseEntity<List<Motorista>> getAllMotoristas() {
        List<Motorista> motoristas = motoristaService.getAllMotoristas();
        return ResponseEntity.ok(motoristas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Motorista> getMotoristaById(@PathVariable String id) {
        Motorista motorista = motoristaService.getMotoristaById(id);
        if (motorista != null) {
            return ResponseEntity.ok(motorista);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<String> createMotorista(@RequestBody Motorista motorista) {
        String id = motoristaService.createMotorista(motorista);
        return ResponseEntity.status(HttpStatus.CREATED).body(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IdResponse> updateMotorista(@PathVariable String id, @RequestBody Motorista motorista) {
        String result = motoristaService.updateMotorista(id, motorista);
        if (result != null) {
            IdResponse response = new IdResponse(result);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMotorista(@PathVariable String id) {
        motoristaService.deleteMotorista(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/login")
    public ResponseEntity<IdResponse> loginMotorista(@RequestBody Login login) {
        IdResponse response = new IdResponse(motoristaService.loginMotorista(login));

        return ResponseEntity.ok(response);
    }
}