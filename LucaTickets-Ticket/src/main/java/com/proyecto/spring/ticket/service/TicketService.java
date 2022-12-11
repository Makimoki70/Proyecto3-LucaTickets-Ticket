package com.proyecto.spring.ticket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.ticket.model.Ticket;
import com.proyecto.spring.ticket.model.response.Event;
import com.proyecto.spring.ticket.model.response.User;
import com.proyecto.spring.ticket.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository repository;
	
	public Ticket comprarTicket(Long id, Long idUser, List<Event> idEvent) { //Fijarse en service de 19d - addproduct. poner para que cree un Ticket
		Ticket ticket = new Ticket();
		
		ticket.setId(id);
		ticket.setIdUser(idUser);
		ticket.setIdEvent(idEvent);
		
		return repository.save(ticket);
	}
	
	public Optional<Ticket> findById(long id) {
		return repository.findById(id);
	} 
}
