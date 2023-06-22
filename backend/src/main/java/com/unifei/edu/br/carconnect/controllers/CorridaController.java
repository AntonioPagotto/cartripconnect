
package com.unifei.edu.br.carconnect.controllers;

import com.unifei.edu.br.carconnect.models.Corrida;
import com.unifei.edu.br.carconnect.models.CorridaPassageiro;
import com.unifei.edu.br.carconnect.models.IdResponse;
import com.unifei.edu.br.carconnect.models.Login;
import com.unifei.edu.br.carconnect.services.CorridaService;
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
@RequestMapping("/corridas")
public class CorridaController {

    private final CorridaService corridaService;

    public CorridaController(CorridaService corridaService) {
        this.corridaService = corridaService;
    }

    @GetMapping
    public ResponseEntity<List<Corrida>> getAllCorridas() {
        List<Corrida> corridas = corridaService.getAllCorridas();
        return ResponseEntity.ok(corridas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Corrida>> getCorridaByMotoristaId(@PathVariable String id) {
        List<Corrida> corrida = corridaService.getCorridaByMotoristaId(id);
        if (corrida != null) {
            return ResponseEntity.ok(corrida);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<IdResponse> createCorrida(@RequestBody Corrida corrida) {

        IdResponse response = new IdResponse(corridaService.createCorrida(corrida));

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IdResponse> updateCorrida(@PathVariable String id, @RequestBody Corrida corrida) {
        String result = corridaService.updateCorrida(id, corrida);
        if (result != null) {
            IdResponse response = new IdResponse(result);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCorrida(@PathVariable String id) {
        corridaService.deleteCorrida(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/passageiros")
    public ResponseEntity<IdResponse> adicionarOuRemoverPassageiro(@RequestBody CorridaPassageiro corridaPassageiro) {
        String result = corridaService.adicionarOuRemoverPassageiro(corridaPassageiro);
        if (result != null) {
            IdResponse response = new IdResponse(result);
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}