package com.hdi.prueba.service;

import org.springframework.stereotype.Service;

import com.hdi.prueba.model.Usuarios;
import com.hdi.prueba.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosService {

    private final UsuarioRepository usuarioRepository ;

    public UsuariosService(UsuarioRepository usuarioRepository ) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuarios> findAllUsers() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuarios> findUserById(int id) {
        return usuarioRepository.findById(id); 
    }
       public Usuarios findUserBycorreo(String correo) {
        return usuarioRepository.findByCorreo(correo); 
    }

    public Usuarios saveUsuario(Usuarios usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteUsuario(int id) {
        usuarioRepository.deleteById(id);
    }
}