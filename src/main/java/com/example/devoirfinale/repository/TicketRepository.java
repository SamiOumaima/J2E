package com.example.devoirfinale.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.devoirfinale.model.*;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
