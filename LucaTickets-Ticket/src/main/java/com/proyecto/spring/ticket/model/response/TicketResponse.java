package com.proyecto.spring.ticket.model.response;

import java.io.Serializable;

import com.proyecto.spring.ticket.model.Event;
import com.proyecto.spring.ticket.model.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TicketResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private User idUser;
	private Event idEvent;
	private double precio;
}