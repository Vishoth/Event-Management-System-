package com.vishoth.ems.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"participant_id","event_id"}))
public class Registration {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(optional=false)
    @JoinColumn(name="participant_id")
    private Participant participant;

    @ManyToOne(optional=false)
    @JoinColumn(name="event_id")
    private Event event;
}
