package com.proyecto.spring.ticket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.spring.ticket.model.Ticket;


public interface TicketRepository extends JpaRepository<Ticket, Long> {
	/*@Query("FROM ticket WHERE idUser = ?1")
	public List<Ticket> findList(long idUser);*/
}