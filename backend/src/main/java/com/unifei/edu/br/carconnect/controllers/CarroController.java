package com.unifei.edu.br.carconnect.controllers;

import com.unifei.edu.br.carconnect.models.IdResponse;
import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.models.Carro;
import com.unifei.edu.br.carconnect.services.CarroService;
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
@RequestMapping("/carros")
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public ResponseEntity<List<Carro>> getAllCarros() {
        List<Carro> carros = carroService.getAllCarros();
        return ResponseEntity.ok(carros);
    }

    @GetMapping("/motorista/{id}")
    public ResponseEntity<List<Carro>> getCarroByMotoristaId(@PathVariable String id) {
        List<Carro> carro = carroService.getCarroByMotoristaId(id);
        if (carro != null) {
            return ResponseEntity.ok(carro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> getCarroById(@PathVariable String id) {
        Carro carro = carroService.getCarroById(id);
        if (carro != null) {
            return ResponseEntity.ok(carro);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<IdResponse> createCarro(@RequestBody Carro carro) {

        IdResponse response = new IdResponse(carroService.createCarro(carro));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IdResponse> updateCarro(@PathVariable String id, @RequestBody Carro carro) {
        String result = carroService.updateCarro(id, carro);
        if (result != null) {
            IdResponse response = new IdResponse(result);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarro(@PathVariable String id) {
        carroService.deleteCarro(id);
        return ResponseEntity.noContent().build();
    }

}