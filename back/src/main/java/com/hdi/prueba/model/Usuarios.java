package com.hdi.prueba.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombreUsuario;

    @Column(name = "correo", length = 50, nullable = false, unique = true)
    private String correo;

    @Column(name = "contrasena", length = 25, nullable = false)
    private String contrasena;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRol")
    private Rol idRol;

    @Column(name = "estatus", nullable = false)
    private Integer estatus;

    public Usuarios() {
    }

    public Usuarios(String nombreUsuario, String correo, String contrasena, Rol idRol, Integer estatus) {
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.idRol = idRol;
        this.estatus = estatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Rol getIdRol() {
        return idRol;
    }

    public void setIdRol(Rol idRol) {
        this.idRol = idRol;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

}
