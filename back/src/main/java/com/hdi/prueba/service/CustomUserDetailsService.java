package com.hdi.prueba.service;
import java.util.Collections;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hdi.prueba.model.Usuarios;
import com.hdi.prueba.repository.UsuarioRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioRepository userRepository;

    public CustomUserDetailsService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuarios user = userRepository.findByCorreo(correo);
        if (user == null) {
            throw new UsernameNotFoundException("no se encuentra el usuario: " + correo);
        }
           if (user.getEstatus() == 0) {
            throw new UsernameNotFoundException("no se encuentra el usuario: ");
        }
        return new org.springframework.security.core.userdetails.User(
            user.getCorreo(), 
            user.getContrasena(), 
            Collections.emptyList() 
        );
    }
}