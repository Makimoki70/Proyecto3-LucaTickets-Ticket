package com.proyecto.spring.ticket.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.spring.ticket.model.Ticket;
import com.proyecto.spring.ticket.model.response.TicketResponse;
import com.proyecto.spring.ticket.service.TicketService;

@RestController
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	TicketService ticketService;
	
	@PostMapping("/{id}/add")
	public ResponseEntity<Ticket> addEvent(@PathVariable Long id, @RequestParam Long idEvent, @RequestParam(defaultValue = "1") Integer qt){
		return ResponseEntity.of(Optional.of(ticketService.comprarTicket(id, idEvent, qt)));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TicketResponse> getTicketById(@PathVariable long id){
		return ResponseEntity.of(Optional.of(ticketService.findById(id)));
	}
}