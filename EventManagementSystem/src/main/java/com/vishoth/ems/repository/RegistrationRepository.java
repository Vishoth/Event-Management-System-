package com.vishoth.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishoth.ems.entity.*;

import java.util.List;
import java.util.Optional;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    List<Registration> findByParticipantId(Long participantId);
    List<Registration> findByEventId(Long eventId);
    Optional<Registration> findByParticipantAndEvent(Participant participant, Event event);
    boolean existsByParticipantIdAndEventId(Long participantId, Long eventId);
    void deleteByParticipantIdAndEventId(Long participantId, Long eventId);
}
