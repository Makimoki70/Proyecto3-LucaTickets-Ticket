package com.proyecto.spring.ticket.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.spring.feigns.EventFeignClient;
import com.proyecto.spring.feigns.MessageFeignClient;
import com.proyecto.spring.feigns.UserFeignClient;
import com.proyecto.spring.ticket.model.Ticket;
import com.proyecto.spring.ticket.model.response.Event;
import com.proyecto.spring.ticket.model.response.Message;
import com.proyecto.spring.ticket.model.response.TicketResponse;
import com.proyecto.spring.ticket.model.response.User;
import com.proyecto.spring.ticket.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	TicketRepository repository;
	

	@Autowired
	private UserFeignClient userFeign;
	
	@Autowired
	private EventFeignClient eventFeign;
	
	@Autowired
	private MessageFeignClient messageFeign;
	
	public Ticket comprarTicket(Long id, Long idUser, List<Long> idEvent) { //Fijarse en service de 19d - addproduct. poner para que cree un Ticket
		Message message = messageFeign.getMessage();
		//Hacer cosas con el mensaje
		Ticket ticket = new Ticket();
		
		ticket.setId(id);
		ticket.setIdUser(idUser);
		ticket.setIdEvent(idEvent);
		
		return repository.save(ticket);
	}
	
	public TicketResponse findById(long id) {
		Ticket ticket = repository.findById(id).orElseThrow();
		User user = userFeign.getUserById(ticket.getIdUser());
		List<Event> events = new ArrayList<>();
		for(Long eId : ticket.getIdEvent()) {
			events.add(eventFeign.getEventById(eId));
		}
		TicketResponse ticketResponse = new TicketResponse();
		ticketResponse.setId(id);
		ticketResponse.setUser(user);
		ticketResponse.setEvent(events);
		
		return ticketResponse;
	} 
	
	public List<TicketResponse> findAll(){
		List<Ticket> tickets = repository.findAll();
		List<TicketResponse> responses = new ArrayList<>();
		
		for(Ticket ticket: tickets) {
			User user = userFeign.getUserById(ticket.getIdUser());
			List<Event> events = new ArrayList<>();
			for(Long eId : ticket.getIdEvent()) {
				events.add(eventFeign.getEventById(eId));
			}
			TicketResponse ticketResponse = new TicketResponse();
			ticketResponse.setId(ticket.getId());
			ticketResponse.setUser(user);
			ticketResponse.setEvent(events);
		}
		return responses;
	}
}
