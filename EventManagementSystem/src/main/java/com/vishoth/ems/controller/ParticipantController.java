package com.vishoth.ems.controller;

import com.vishoth.ems.entity.Participant;
import com.vishoth.ems.service.ParticipantService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/participants")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class ParticipantController {
    private final ParticipantService svc;
    public ParticipantController(ParticipantService svc){ this.svc = svc; }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping public List<Participant> all(){ return svc.getAll(); }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}") public Participant get(@PathVariable Long id){ return svc.get(id); }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}") public void delete(@PathVariable Long id){ svc.delete(id); }
}
