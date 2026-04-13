package com.hdi.prueba.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hdi.prueba.model.Reporte;
import com.hdi.prueba.model.ReporteDTO;
import com.hdi.prueba.model.Siniestro;
import com.hdi.prueba.service.ReporteService;
import com.hdi.prueba.service.UsuariosService;
import com.hdi.prueba.service.PolizaService;
import com.hdi.prueba.util.ValidateDatePoliza;


import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/reportes")
public class ReporteController {

    private final ReporteService reporteService;
    private final UsuariosService usuarioService;
    private final PolizaService polizaService;


    public ReporteController(ReporteService reporteService, 
                             PolizaService polizaService,
                             UsuariosService usuarioService) {
        this.reporteService = reporteService;
        this.usuarioService = usuarioService;
        this.polizaService = polizaService;
    }

    @GetMapping
    public List<Reporte> getAllReportes() {
        return reporteService.findAllReportes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reporte> getReporteById(@PathVariable int id) {
        Optional<Reporte> reporte = reporteService.findReporteById(id);
        return reporte.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Siniestro createReporte(@RequestBody ReporteDTO reporte) {
        Reporte saveReport = new Reporte();
        saveReport.setFechaOcurrencia(reporte.getFechaOcurrencia());
        saveReport.setColor(reporte.getColor());
        saveReport.setDescripcionSiniestro(reporte.getDescripcionSiniestro());
        saveReport.setLugarSiniestro(reporte.getLugarSiniestro());
        saveReport.setNombreAjustador(reporte.getNombreAjustador());
        saveReport.setNombreReporta(reporte.getNombreReporta());
        saveReport.setObservaciones(reporte.getObservaciones());
        saveReport.setPlacas(reporte.getPlacas());
        saveReport.setTelefonoContacto(reporte.getTelefonoContacto());
        saveReport.setCorreoElectronico(reporte.getCorreoElectronico());
        saveReport.setCorreoAjustador(usuarioService.findUserBycorreo(reporte.getCorreoAjustador()));
        saveReport.setIdPoliza(polizaService.findByIdPoliza(reporte.getIdPoliza()));  
        if(ValidateDatePoliza.isReporteValidDate(saveReport.getFechaOcurrencia(),saveReport.getIdPoliza().getFinVigencia(),saveReport.getIdPoliza().getInicioVigencia())){
            return reporteService.saveReporteAndSiniestro(saveReport);
        }else{
            return new Siniestro();
        }
       
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReporte(@PathVariable int id) {
        reporteService.deleteReporte(id);
        return ResponseEntity.noContent().build();
    }
}