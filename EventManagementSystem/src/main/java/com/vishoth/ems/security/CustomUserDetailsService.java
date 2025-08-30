package com.vishoth.ems.security;

import com.vishoth.ems.entity.Participant;
import com.vishoth.ems.repository.ParticipantRepository;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final ParticipantRepository repo;
    public CustomUserDetailsService(ParticipantRepository repo){ this.repo = repo; }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Participant p = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return User.withUsername(p.getEmail())
                .password(p.getPassword())
                .roles(p.getRole())
                .build();
    }
}
