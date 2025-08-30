package com.vishoth.ems.controller;

import com.vishoth.ems.entity.Event;
import com.vishoth.ems.service.EventService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin(origins = "${app.cors.allowed-origins}")
public class EventController {
    private final EventService svc;
    public EventController(EventService svc){ this.svc = svc; }

    @GetMapping public List<Event> all(){ return svc.getAllEvents(); }
    @GetMapping("/{id}") public Event get(@PathVariable Long id){ return svc.getEvent(id); }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping public Event create(@RequestBody Event e){ return svc.saveEvent(e); }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event e){
        e.setId(id); return svc.saveEvent(e);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ svc.deleteEvent(id); }
}
