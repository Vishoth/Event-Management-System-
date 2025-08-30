package com.vishoth.ems.controller;

import com.vishoth.ems.dto.*;
import com.vishoth.ems.entity.Participant;
import com.vishoth.ems.service.AuthService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class AuthController {
    private final AuthService authService;
    public AuthController(AuthService authService){ this.authService = authService; }

    @PostMapping("/register")
    public Participant register(@RequestBody RegisterRequest req){ return authService.register(req); }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest req){ return authService.login(req); }
}
