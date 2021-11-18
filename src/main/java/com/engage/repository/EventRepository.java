package com.engage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engage.domain.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

}

