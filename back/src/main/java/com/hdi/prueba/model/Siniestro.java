package com.hdi.prueba.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "siniestros")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "numeroSiniestro", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idReporte")
    private Reporte idReporte;

    @Column(name = "fechaRegistro",  nullable = false)
    private Date fechaRegistro;
    
    @Column(name = "nombreAjustador", length = 100, nullable = false)
    private String nombreAjustador;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "correo")
    private Usuarios correoAjustador;

    public Siniestro() {
    }

    public Siniestro(Reporte idReporte, Date fechaRegistro, String nombreAjustador, Usuarios correoAjustador) {
        this.idReporte = idReporte;
        this.fechaRegistro = fechaRegistro;
        this.nombreAjustador = nombreAjustador;
        this.correoAjustador = correoAjustador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Reporte getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(Reporte idReporte) {
        this.idReporte = idReporte;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getNombreAjustador() {
        return nombreAjustador;
    }

    public void setNombreAjustador(String nombreAjustador) {
        this.nombreAjustador = nombreAjustador;
    }

    public Usuarios getCorreoAjustador() {
        return correoAjustador;
    }

    public void setCorreoAjustador(Usuarios correoAjustador) {
        this.correoAjustador = correoAjustador;
    }
}
