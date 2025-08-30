package com.vishoth.ems.service;

import com.vishoth.ems.entity.Participant;
import com.vishoth.ems.repository.ParticipantRepository;

import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ParticipantService {
    private final ParticipantRepository repo;
    public ParticipantService(ParticipantRepository repo){ this.repo=repo; }
    public List<Participant> getAll(){ return repo.findAll(); }
    public Participant get(Long id){ return repo.findById(id).orElseThrow(); }
    public Participant save(Participant p){ return repo.save(p); }
    public void delete(Long id){ repo.deleteById(id); }
}
