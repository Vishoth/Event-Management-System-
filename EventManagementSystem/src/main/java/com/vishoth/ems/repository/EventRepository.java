package com.vishoth.ems.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishoth.ems.entity.Event;
public interface EventRepository extends JpaRepository<Event, Long> {}
