package com.engage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.engage.domain.EventInformation;

@Repository
public interface EventInformationRepository extends JpaRepository<EventInformation, Long> {

}

