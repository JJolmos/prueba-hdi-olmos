package com.hdi.prueba.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hdi.prueba.model.Usuarios;
import com.hdi.prueba.service.UsuariosService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;

    public UsuariosController(UsuariosService usuariosService) {
        this.usuariosService = usuariosService;
    }

    @GetMapping
    public List<Usuarios> getAllUsuarioss() {
        return usuariosService.findAllUsers();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Usuarios> getUsuariosById(@PathVariable int id) {
        Optional<Usuarios> usuario = usuariosService.findUserById(id);
        return usuario.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Usuarios createUsuarios(@RequestBody Usuarios usuario) {
        return usuariosService.saveUsuario(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuarios> updateUsuarios(@PathVariable int id, @RequestBody Usuarios userDetails) {
        Optional<Usuarios> userOptional = usuariosService.findUserById(id);

        if (userOptional.isPresent()) {
            Usuarios usuario = userOptional.get();
            usuario.setContrasena(userDetails.getContrasena());
            usuario.setCorreo(userDetails.getCorreo());
            usuario.setEstatus(userDetails.getEstatus()); 
            usuario.setIdRol(userDetails.getIdRol());
            usuario.setNombreUsuario(userDetails.getNombreUsuario());
            final Usuarios updatedUsuarios = usuariosService.saveUsuario(usuario);
            return ResponseEntity.ok(updatedUsuarios);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuarios(@PathVariable int id) {
        usuariosService.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}