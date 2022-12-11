package com.proyecto.spring.ticket.model.response;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class TicketResponse implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private User user;
	private Event event;
	private double price;
}