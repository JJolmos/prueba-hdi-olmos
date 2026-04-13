package com.hdi.prueba.model;

public class UsuarioDTO {

    private Integer id;
    private String nombreUsuario;
    private String correo;
    private Integer idRol;
    private Integer estatus;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String nombreUsuario, String correo, Integer idRol, Integer estatus) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.correo = correo;
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

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getEstatus() {
        return estatus;
    }

    public void setEstatus(Integer estatus) {
        this.estatus = estatus;
    }

}