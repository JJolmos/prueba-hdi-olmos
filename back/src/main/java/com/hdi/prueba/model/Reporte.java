
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
@Table(name = "reportes")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReporte", nullable = false)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPoliza")
    private Poliza idPoliza;

    @Column(name = "fechaOcurrencia",  nullable = false, unique = true)
    private Date fechaOcurrencia;
    
    @Column(name = "lugarSiniestro", length = 100, nullable = false)
    private String lugarSiniestro;
    
    @Column(name = "nombreReporta", length = 100, nullable = false)
    private String nombreReporta;
    
    @Column(name = "telefonoContacto", length = 10, nullable = false)
    private String telefonoContacto;
    
    @Column(name = "correoElectronico", length = 50, nullable = false)
    private String correoElectronico;
    
    @Column(name = "descripcionSiniestro", length = 100, nullable = false)
    private String descripcionSiniestro;

    @Column(name = "placas", length = 10, nullable = false)    
    private String placas;

    @Column(name = "color", length = 10, nullable = false)
    private String color;

    @Column(name = "observaciones", length = 100, nullable = true)
    private String observaciones;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "correo")
    private Usuarios correoAjustador;

    @Column(name = "nombreAjustador", length = 100, nullable = false)
    private String nombreAjustador;

    public Reporte() {
    }

    public Reporte(Poliza idPoliza, Date fechaOcurrencia, String lugarSiniestro, String nombreReporta,
            String telefonoContacto, String correoElectronico, String descripcionSiniestro, String placas, String color,
            String observaciones, Usuarios correoAjustador, String nombreAjustador) {
        this.idPoliza = idPoliza;
        this.fechaOcurrencia = fechaOcurrencia;
        this.lugarSiniestro = lugarSiniestro;
        this.nombreReporta = nombreReporta;
        this.telefonoContacto = telefonoContacto;
        this.correoElectronico = correoElectronico;
        this.descripcionSiniestro = descripcionSiniestro;
        this.placas = placas;
        this.color = color;
        this.observaciones = observaciones;
        this.correoAjustador = correoAjustador;
        this.nombreAjustador = nombreAjustador;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Poliza getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Poliza idPoliza) {
        this.idPoliza = idPoliza;
    }

    public Date getFechaOcurrencia() {
        return fechaOcurrencia;
    }

    public void setFechaOcurrencia(Date fechaOcurrencia) {
        this.fechaOcurrencia = fechaOcurrencia;
    }

    public String getLugarSiniestro() {
        return lugarSiniestro;
    }

    public void setLugarSiniestro(String lugarSiniestro) {
        this.lugarSiniestro = lugarSiniestro;
    }

    public String getNombreReporta() {
        return nombreReporta;
    }

    public void setNombreReporta(String nombreReporta) {
        this.nombreReporta = nombreReporta;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

        public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getDescripcionSiniestro() {
        return descripcionSiniestro;
    }

    public void setDescripcionSiniestro(String descripcionSiniestro) {
        this.descripcionSiniestro = descripcionSiniestro;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Usuarios getCorreoAjustador() {
        return correoAjustador;
    }

    public void setCorreoAjustador(Usuarios correoAjustador) {
        this.correoAjustador = correoAjustador;
    }

    public String getNombreAjustador() {
        return nombreAjustador;
    }

    public void setNombreAjustador(String nombreAjustador) {
        this.nombreAjustador = nombreAjustador;
    }
}