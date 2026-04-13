
package com.hdi.prueba.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.hdi.prueba.model.Poliza;
import com.hdi.prueba.repository.PolizaRepository;

import jakarta.transaction.Transactional;

@Service
public class PolizaService {

    private final PolizaRepository polizaRepository;

    public PolizaService(PolizaRepository polizaRepository) {
        this.polizaRepository = polizaRepository;
    }

    @Transactional
    public Poliza guardarPoliza(Poliza poliza) {
        Poliza guardado = polizaRepository.saveAndFlush(poliza);
        String idPoliza = guardado.getOficinaEmision() + "" + guardado.getNoPoliza();
        guardado.setIdPoliza(idPoliza);
        return guardado;
    }

    public List<Poliza> findAllPolizas() {
        return polizaRepository.findAll();
    }

    public Optional<Poliza> findPolizaById(int id) {
        return polizaRepository.findById(id);
    }

    
    public Poliza findByIdPoliza(int idPoliza) {
        return polizaRepository.findByIdPoliza(idPoliza);
    }

    public void deletePoliza(int id) {
        polizaRepository.deleteById(id);
    }

    public Poliza findByAsegurado(String asegurado) {
        return polizaRepository.findByAsegurado(asegurado);
    }

    public List<Poliza> findByAseguradoContainingIgnoreCase(String asegurado) {
        return polizaRepository.findByAseguradoContainingIgnoreCase(asegurado);
    }

    public List<Poliza> findByAseguradoContainingIgnoreCaseOrNoPoliza(String asegurado,Integer noPoliza) {
        return polizaRepository.findByAseguradoContainingIgnoreCaseOrNoPoliza(asegurado, noPoliza);
    }

}