package com.proyecto.spring.ticket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.ticket.model.Ticket;
import com.proyecto.spring.ticket.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/add")
	public ResponseEntity<Ticket> addEvent(@RequestBody Ticket ticket){
		return ResponseEntity.of(Optional.of(ticketService.comprarTicket(ticket)));
	}
}
