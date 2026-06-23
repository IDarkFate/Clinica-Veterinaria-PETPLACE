package com.petsplace.gestion.auth.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JwtAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        // Devuelve un JSON limpio con código 403 Forbidden cuando el usuario está
        // autenticado pero no tiene los roles requeridos para el endpoint
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_FORBIDDEN); // Retorna HTTP 403
        response.getOutputStream()
                .println("{ \"error\": \"Acceso denegado\", \"message\": \"" + accessDeniedException.getMessage() + "\" }");
    }
}
