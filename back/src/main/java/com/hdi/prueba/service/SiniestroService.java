package com.hdi.prueba.service;

import org.springframework.stereotype.Service;

import com.hdi.prueba.model.Siniestro;
import com.hdi.prueba.repository.SiniestroRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SiniestroService {

    private final SiniestroRepository siniestroRepository ;

    public SiniestroService(SiniestroRepository siniestroRepository ) {
        this.siniestroRepository = siniestroRepository;
    }

    public List<Siniestro> findAllSiniestros() {
        return siniestroRepository.findAll();
    }

    public Optional<Siniestro> findSiniestroById(int id) {
        return siniestroRepository.findById(id); 
    }

    public Siniestro saveSiniestro(Siniestro siniestro) {
        return siniestroRepository.save(siniestro);
    }

    public void deleteSiniestro(int id) {
        siniestroRepository.deleteById(id);
    }
}