package com.example.demo.helper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.logging.Logger;

@Component
public class RequestLoggingFilter extends OncePerRequestFilter {

    private static final Logger log = Logger.getLogger(RequestLoggingFilter.class.getName());

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        long start = System.currentTimeMillis();

        log.info(String.format("[REQUEST] %s %s from %s",
                request.getMethod(), request.getRequestURI(), request.getRemoteAddr()));

        filterChain.doFilter(request, response);

        long duration = System.currentTimeMillis() - start;

        log.info(String.format("[RESPONSE] %s %s -> %d (%dms)",
                request.getMethod(), request.getRequestURI(),
                response.getStatus(), duration));
    }
}
