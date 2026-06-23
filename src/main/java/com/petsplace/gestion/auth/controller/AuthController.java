package com.petsplace.gestion.auth.controller;

import com.petsplace.gestion.auth.dto.LoginRequest;
import com.petsplace.gestion.auth.dto.LoginResponse;
import com.petsplace.gestion.auth.dto.RegisterRequest;
import com.petsplace.gestion.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*") // Habilita la comunicación directa con tu frontend de React
public class AuthController {

    @Autowired
    private AuthService authService;

    /**
     * ENDPOINT DE REGISTRO
     */
    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registrar(@RequestBody RegisterRequest request) {
        String mensaje = authService.registrar(request);
        Map<String, String> response = new HashMap<>();
        response.put("message", mensaje);
        return ResponseEntity.ok(response);
    }

    /**
     * ENDPOINT DE LOGIN
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        LoginResponse response = authService.login(request);
        return ResponseEntity.ok(response);
    }

    /**
     * ENDPOINT DE CONTEXTO (USUARIO ACTUAL)
     * Crucial para Petsplace. Permite que React sepa qué usuario está usando el
     * sistema
     * en tiempo real para pintar su nombre y gestionar los permisos en el
     * dashboard.
     */
    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> obtenerUsuarioActual(Authentication authentication) {
        // Si el token expiró o no se envió correctamente, denegamos el acceso
        if (authentication == null || !authentication.isAuthenticated()) {
            return ResponseEntity.status(401).build();
        }

        // Construimos una respuesta útil para la interfaz de la veterinaria
        Map<String, Object> usuarioActual = new HashMap<>();
        usuarioActual.put("email", authentication.getName());
        usuarioActual.put("permisos", authentication.getAuthorities());

        return ResponseEntity.ok(usuarioActual);
    }
}