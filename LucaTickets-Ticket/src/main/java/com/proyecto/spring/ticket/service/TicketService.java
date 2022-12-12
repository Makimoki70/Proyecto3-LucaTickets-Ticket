package com.proyecto.spring.ticket.service;

import java.util.ArrayList;
import java.util.List;

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
	private TicketRepository repository;

	@Autowired
	private UserFeignClient userFeign;
	
	@Autowired
	private EventFeignClient eventFeign;
	
	@Autowired
	private MessageFeignClient messageFeign;
	
	//cambiar el idEvent de nuevo a long en lugar de Lista
	public void comprarTicket(long idUser, long idEvent, int qt) { //Fijarse en service de 19d - addproduct. poner para que cree un Ticket
		Message message = messageFeign.getMessage();
		//Hacer cosas con el mensaje

		final User user = userFeign.getUserById(idUser);

		final Event event = eventFeign.getEventById(idEvent);

		Ticket ticket = new Ticket();
		
		for(int i = 0; i<qt; i++) {
			ticket.setIdUser(idUser);
			ticket.setIdEvent(idEvent);
			ticket.setPrecio(event.getPrecio());
			System.out.println("---------------------------------- " + ticket.toString());
			repository.save(ticket);
			System.out.println("---------------------------------- Paso de aqui");
		}
		
		//Revisar que devolver como lista
		
	}
	
	//Hacer un get del repositorio como en el service de 18 (ver si esta en la base de datos del producto) haciendo findbyid, si salta, listo. Si no salta (no esta)
	//hacer un orElse y dentro crear nuevo usuario
	
	
	public TicketResponse findById(long id) {
		Ticket ticket = repository.findById(id).orElseThrow();
		User user = userFeign.getUserById(ticket.getIdUser());
		List<Event> events = new ArrayList<>();
		
		
		/*for(Long eId : ticket.getIdEvent()) {
			events.add(eventFeign.getEventById(eId));
		}*/
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
			/*for(Long eId : ticket.getIdEvent()) {
				events.add(eventFeign.getEventById(eId));
			}*/
			TicketResponse ticketResponse = new TicketResponse();
			ticketResponse.setId(ticket.getId());
			ticketResponse.setUser(user);
			ticketResponse.setEvent(events);
		}
		return responses;
	}
	//Busqueda por usuario para los tickets
}





