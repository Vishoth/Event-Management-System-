package com.vishoth.ems.controller;

import com.vishoth.ems.entity.Registration;
import com.vishoth.ems.service.RegistrationService;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class RegistrationController {
    private final RegistrationService svc;
    public RegistrationController(RegistrationService svc){ this.svc = svc; }

    @PostMapping
    public Registration register(@RequestParam Long participantId, @RequestParam Long eventId) {
        return svc.register(participantId, eventId);
    }

    @DeleteMapping
    public String unregister(@RequestParam Long participantId, @RequestParam Long eventId) {
        svc.unregister(participantId, eventId); return "Unregistered";
    }

    @GetMapping("/me")
    public List<Registration> my(@RequestParam Long participantId) { return svc.myRegistrations(participantId); }

    @GetMapping
    public List<Registration> all(){ return svc.allRegistrations(); }
}
