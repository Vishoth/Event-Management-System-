package com.vishoth.ems.service;

import com.vishoth.ems.entity.*;
import com.vishoth.ems.repository.*;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepository regRepo;
    private final ParticipantRepository partRepo;
    private final EventRepository eventRepo;

    public RegistrationService(RegistrationRepository r, ParticipantRepository p, EventRepository e){
        this.regRepo = r; this.partRepo = p; this.eventRepo = e;
    }

    public Registration register(Long participantId, Long eventId){
        Participant p = partRepo.findById(participantId).orElseThrow();
        Event e = eventRepo.findById(eventId).orElseThrow();
        if (regRepo.findByParticipantAndEvent(p,e).isPresent()) {
            throw new IllegalStateException("Already registered");
        }
        Registration reg = new Registration();
        reg.setParticipant(p); reg.setEvent(e);
        return regRepo.save(reg);
    }

    public void unregister(Long participantId, Long eventId){
        regRepo.deleteByParticipantIdAndEventId(participantId, eventId);
    }

    public List<Registration> myRegistrations(Long participantId){
        return regRepo.findByParticipantId(participantId);
    }

    public List<Registration> allRegistrations(){ return regRepo.findAll(); }
}
