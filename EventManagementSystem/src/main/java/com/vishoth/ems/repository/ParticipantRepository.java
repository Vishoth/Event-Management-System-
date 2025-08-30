package com.vishoth.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishoth.ems.entity.Participant;

import java.util.Optional;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Optional<Participant> findByEmail(String email);
    boolean existsByEmail(String email);
}
