package com.hdi.prueba.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hdi.prueba.model.Poliza;
import com.hdi.prueba.service.PolizaService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/polizas")
public class PolizaController {

    private final PolizaService polizaService;

    public PolizaController(PolizaService polizaService) {
        this.polizaService = polizaService;
    }

    @GetMapping
    public List<Poliza> getAllPolizas() {
        return polizaService.findAllPolizas();
    }

   @GetMapping("/getPolizaByAseguradoOrNoPoliza")
    public List<Poliza> getPolizaByAseguradoOrNoPoliza(  @RequestParam String asegurado, @RequestParam(required = false) Optional<Integer> noPoliza) {
        Integer numero = noPoliza.orElse(null); 
        return polizaService.findByAseguradoContainingIgnoreCaseOrNoPoliza(asegurado, numero);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Poliza> getPolizaById(@PathVariable int id) {
        Optional<Poliza> poliza = polizaService.findPolizaById(id);
        return poliza.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Poliza createPoliza(@RequestBody Poliza poliza) {
        return polizaService.guardarPoliza(poliza);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePoliza(@PathVariable int id) {
        polizaService.deletePoliza(id);
        return ResponseEntity.noContent().build();
    }
}