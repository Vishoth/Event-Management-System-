package com.vishoth.ems.service;

import com.vishoth.ems.entity.Event;
import com.vishoth.ems.repository.EventRepository;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventService {
    private final EventRepository repo;
    public EventService(EventRepository repo){ this.repo=repo; }
    public Event saveEvent(Event e){ return repo.save(e); }
    public List<Event> getAllEvents(){ return repo.findAll(); }
    public Event getEvent(Long id){ return repo.findById(id).orElseThrow(); }
    public void deleteEvent(Long id){ repo.deleteById(id); }
}
