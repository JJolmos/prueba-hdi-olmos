package com.hdi.prueba.service;

import org.springframework.stereotype.Service;

import com.hdi.prueba.model.Reporte;
import com.hdi.prueba.model.Siniestro;
import com.hdi.prueba.repository.ReporteRepository;
import com.hdi.prueba.repository.SiniestroRepository;

import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReporteService {

    private final ReporteRepository reporteRepository;
    private final SiniestroRepository siniestroRepository;

    public ReporteService(ReporteRepository reporteRepository, SiniestroRepository siniestroRepository) {
        this.reporteRepository = reporteRepository;
        this.siniestroRepository = siniestroRepository;
    }

    public List<Reporte> findAllReportes() {
        return reporteRepository.findAll();
    }

    public Optional<Reporte> findReporteById(int id) {
        return reporteRepository.findById(id);
    }

    public Reporte saveReporte(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    @Transactional
    public Siniestro saveReporteAndSiniestro(Reporte reporte) {
         Reporte _reporte = reporteRepository.save(reporte);
         Siniestro siniestro = new Siniestro(_reporte, new Date(), reporte.getNombreAjustador(), reporte.getCorreoAjustador());
         return siniestroRepository.save(siniestro);
    }

    public void deleteReporte(int id) {
        reporteRepository.deleteById(id);
    }
}