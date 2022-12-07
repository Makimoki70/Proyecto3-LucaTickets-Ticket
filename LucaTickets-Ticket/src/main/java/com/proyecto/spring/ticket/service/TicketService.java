package com.proyecto.spring.ticket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.ticket.model.Ticket;
import com.proyecto.spring.ticket.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository repository;
	
	public Ticket comprarTicket(Ticket ticket) {
		return repository.save(ticket);
	}
}
