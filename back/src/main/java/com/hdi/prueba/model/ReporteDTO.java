package com.hdi.prueba.model;

import java.util.Date;

public class ReporteDTO {

    private Integer id;
    private Integer idPoliza;
    private Date fechaOcurrencia;
    private String lugarSiniestro;
    private String nombreReporta;
    private String telefonoContacto;
    private String correoElectronico;
    private String descripcionSiniestro;
    private String placas;
    private String color;
    private String observaciones;
    private String correoAjustador;
    private String nombreAjustador;

    public ReporteDTO() {
    }

    public ReporteDTO(Integer id, Integer idPoliza, Date fechaOcurrencia, String lugarSiniestro, String nombreReporta,
            String telefonoContacto, String correoElectronico, String descripcionSiniestro, String placas, String color,
            String observaciones, String correoAjustador, String nombreAjustador) {
        this.id = id;
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

    public Integer getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(Integer idPoliza) {
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

    public String getCorreoAjustador() {
        return correoAjustador;
    }

    public void setCorreoAjustador(String correoAjustador) {
        this.correoAjustador = correoAjustador;
    }

    public String getNombreAjustador() {
        return nombreAjustador;
    }

    public void setNombreAjustador(String nombreAjustador) {
        this.nombreAjustador = nombreAjustador;
    }

}
