package com.proyecto.spring.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.spring.ticket.model.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
