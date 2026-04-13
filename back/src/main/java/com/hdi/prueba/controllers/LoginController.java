package com.hdi.prueba.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdi.prueba.model.UsuarioDTO;
import com.hdi.prueba.model.Usuarios;
import com.hdi.prueba.service.UsuariosService;
import com.hdi.prueba.util.JwtUtils;


@RestController
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuariosService usuariosService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuarios loginRequest) {
       try {
            Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getCorreo(), loginRequest.getContrasena()));

            String jwt = jwtUtils.generateJwtToken(authentication);
            Usuarios _usuario = usuariosService.findUserBycorreo(authentication.getName());
            UsuarioDTO dto = new UsuarioDTO(_usuario.getId(), _usuario.getNombreUsuario(), _usuario.getCorreo(), _usuario.getIdRol().getIdRol(), _usuario.getEstatus());
            Map<String, Object> response = new HashMap<>();
            response.put("token", jwt);
            response.put("usuario", dto);
            return ResponseEntity.ok(response);

        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Error: Usuario o contraseña incorrectos");
        }
    }
}