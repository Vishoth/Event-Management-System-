package com.vishoth.ems;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.vishoth.ems.entity.Participant;


@SpringBootApplication
public class EventManagementSystemApplication {
    public static void main(String[] args){ SpringApplication.run(EventManagementSystemApplication.class,args); }

    @Bean
    CommandLineRunner seedAdmin(com.vishoth.ems.repository.ParticipantRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (!repo.existsByEmail("admin@ems.com")) {
                Participant admin = Participant.builder()
                    .name("Admin")
                    .email("admin@ems.com")
                    .password(encoder.encode("admin123"))
                    .role("ADMIN")
                    .build();
                repo.save(admin);
                System.out.println("Admin created: admin@ems.com / admin123");
            }
        };
    }
}
