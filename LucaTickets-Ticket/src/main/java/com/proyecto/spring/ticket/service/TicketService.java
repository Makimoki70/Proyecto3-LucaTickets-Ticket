package com.proyecto.spring.ticket.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.proyecto.spring.feigns.EventFeignClient;
import com.proyecto.spring.feigns.MessageFeignClient;
import com.proyecto.spring.feigns.UserFeignClient;
import com.proyecto.spring.ticket.controller.error.CustomErrorJson;
import com.proyecto.spring.ticket.model.Ticket;
import com.proyecto.spring.ticket.model.response.Event;
import com.proyecto.spring.ticket.model.response.Message;
import com.proyecto.spring.ticket.model.response.TicketResponse;
import com.proyecto.spring.ticket.model.response.User;
import com.proyecto.spring.ticket.repository.TicketRepository;

@Service
public class TicketService {
	
	@Autowired
	private TicketRepository repository;

	@Autowired
	private UserFeignClient userFeign;
	
	@Autowired
	private EventFeignClient eventFeign;
	
	@Autowired
	private MessageFeignClient messageFeign;
	
	//cambiar el idEvent de nuevo a long en lugar de Lista
	public ResponseEntity<Object> comprarTicket(long idUser, long idEvent, int qt) { //Fijarse en service de 19d - addproduct. poner para que cree un Ticket
		Message message = messageFeign.getMessage();
		
		
		//Deberia estar en un sitio mas adecuado pero hay tiempo
		CustomErrorJson customError = new CustomErrorJson();
		switch(message.getStatus()) {
		case "400.1454":
			customError.setTimestamp(new Date());
			customError.setStatus(HttpStatus.BAD_REQUEST.value());
			customError.setError(message.getStatus() + ": " + message.getBody());
			return new ResponseEntity<>(customError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		case "400.1030":
			customError.setTimestamp(new Date());
			customError.setStatus(HttpStatus.BAD_REQUEST.value());
			customError.setError(message.getStatus() + ": " + message.getBody());
			return new ResponseEntity<>(customError, new HttpHeaders(), HttpStatus.BAD_REQUEST);
		case "500.1049":
			customError.setTimestamp(new Date());
			customError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customError.setError(message.getStatus() + ": " + message.getBody());
			return new ResponseEntity<>(customError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		case "500.3004":
			customError.setTimestamp(new Date());
			customError.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
			customError.setError(message.getStatus() + ": " + message.getBody());
			return new ResponseEntity<>(customError, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		default:
			final User user = userFeign.getUserById(idUser);

			final Event event = eventFeign.getEventById(idEvent);

			Ticket ticket = new Ticket();
			
			for(int i = 0; i<qt; i++) {
				ticket.setIduser(idUser);
				ticket.setIdevent(idEvent);
				ticket.setPrecio(event.getPrecio());
				System.out.println("---------------------------------- " + ticket.toString());
				repository.save(ticket);
				System.out.println("---------------------------------- Paso de aqui");
			}
			return ResponseEntity.status(HttpStatus.OK).body(message.getBody());
		}		
	}
	
	
	
	public TicketResponse findById(long id) {
		User user = userFeign.getUserById(id);
		List<Ticket> tickets = repository.findList(id);
		List<Event> events = new ArrayList<>();
		
		for(Ticket t : tickets) {
			events.add(eventFeign.getEventById(t.getIdevent()));
		}
		TicketResponse ticketResponse = new TicketResponse();
		ticketResponse.setId(id);
		ticketResponse.setUser(user);
		ticketResponse.setEvent(events);
		
		return ticketResponse;
	}
	
	public List<TicketResponse> findAll(){
		List<TicketResponse> responses = new ArrayList<>();
		List<Long> ids = repository.getDistinctIds();
		
		for(Long id: ids) {
			responses.add(this.findById(id));
		}
		
		return responses;
	}
}





