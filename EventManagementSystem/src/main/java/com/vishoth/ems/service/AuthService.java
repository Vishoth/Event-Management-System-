package com.vishoth.ems.service;

import com.vishoth.ems.dto.*;
import com.vishoth.ems.entity.Participant;
import com.vishoth.ems.repository.ParticipantRepository;
import com.vishoth.ems.security.JwtUtil;

import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final ParticipantRepository participantRepo;
    private final PasswordEncoder encoder;

    public AuthService(AuthenticationManager authManager, JwtUtil jwtUtil,
                       ParticipantRepository participantRepo, PasswordEncoder encoder) {
        this.authManager = authManager; this.jwtUtil = jwtUtil;
        this.participantRepo = participantRepo; this.encoder = encoder;
    }

    public Participant register(RegisterRequest req) {
        if (participantRepo.existsByEmail(req.getEmail())) {
            throw new IllegalStateException("Email already used");
        }
        Participant p = Participant.builder()
                .name(req.getName())
                .email(req.getEmail())
                .password(encoder.encode(req.getPassword()))
                .role("PARTICIPANT")
                .build();
        return participantRepo.save(p);
    }

    public LoginResponse login(LoginRequest req) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));
        Participant p = participantRepo.findByEmail(req.getEmail()).orElseThrow();
        String token = jwtUtil.generateToken(p.getEmail());
        return new LoginResponse(token, p.getRole(), p.getName());
    }
}
