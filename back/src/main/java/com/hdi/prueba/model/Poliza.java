package com.hdi.prueba.model;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "polizas")
public class Poliza {

    @Column(name = "idPoliza", updatable = false, nullable = false)
    private String idPoliza;

    @Column(name = "liNeanegocio", length = 50, nullable = false)
    private String liNeanegocio;

    @Column(name = "oficinaEmision", nullable = false)
    private Integer oficinaEmision;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "noPoliza", nullable = false)
    private Integer noPoliza;

    @Column(name = "asegurado", nullable = false)
    private String asegurado;

    @Column(name = "beneficiario", nullable = true)
    private String beneficiario;

    @Column(name = "inicioVigencia",  nullable = false)
    private Date inicioVigencia;

    @Column(name = "finVigencia",  nullable = false)
    private Date finVigencia;

    @Column(name = "fechaemision",  nullable = false)
    private Date fechaEmision;

    @Column(name = "periodicidad", length = 10, nullable = false)
    private String periodicidad;
    
    @Column(name = "vehiculoAsegurado", length = 30, nullable = false)
    private String vehiculoAsegurado;

    public Poliza() {
    }

    public Poliza(String liNeanegocio, Integer oficinaEmision, String asegurado, String beneficiario, Date inicioVigencia, Date finVigencia, Date fechaEmision, String periodicidad, String vehiculoAsegurado) {
        this.liNeanegocio = liNeanegocio;
        this.oficinaEmision = oficinaEmision;
        this.asegurado = asegurado;
        this.beneficiario = beneficiario;
        this.inicioVigencia = inicioVigencia;
        this.finVigencia = finVigencia;
        this.fechaEmision = fechaEmision;
        this.periodicidad = periodicidad;
        this.vehiculoAsegurado = vehiculoAsegurado;
    }

    public String getIdPoliza() {
        return idPoliza;
    }

    public void setIdPoliza(String idPoliza) {
        this.idPoliza = idPoliza;
    }

    public String getLiNeanegocio() {
        return liNeanegocio;
    }

    public void setLiNeanegocio(String liNeanegocio) {
        this.liNeanegocio = liNeanegocio;
    }

    public Integer getOficinaEmision() {
        return oficinaEmision;
    }

    public void setOficinaEmision(Integer oficinaEmision) {
        this.oficinaEmision = oficinaEmision;
    }

    public Integer getNoPoliza() {
        return noPoliza;
    }

    public void setNoPoliza(Integer noPoliza) {
        this.noPoliza = noPoliza;
    }

    public String getAsegurado() {
        return asegurado;
    }

    public void setAsegurado(String asegurado) {
        this.asegurado = asegurado;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Date getInicioVigencia() {
        return inicioVigencia;
    }

    public void setInicioVigencia(Date inicioVigencia) {
        this.inicioVigencia = inicioVigencia;   
    }
    public Date getFinVigencia() {
        return finVigencia;
    }

    public void setFinVigencia(Date finVigencia) {
        this.finVigencia = finVigencia;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getPeriodicidad() {
        return periodicidad;
    }

    public void setPeriodicidad(String periodicidad) {
        this.periodicidad = periodicidad;
    }

    public String getVehiculoAsegurado() {
        return vehiculoAsegurado;
    }

    public void setVehiculoAsegurado(String vehiculoAsegurado) {
        this.vehiculoAsegurado = vehiculoAsegurado;
    }
    
}
