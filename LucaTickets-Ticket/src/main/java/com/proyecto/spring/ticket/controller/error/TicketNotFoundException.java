package com.proyecto.spring.ticket.controller.error;

public class TicketNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public TicketNotFoundException(){
		super("Error: No existe ese evento");
	}
	public TicketNotFoundException(Long id){
		super("Error: No existe el evento "+id);
	}
	public TicketNotFoundException(String s){
		super("Error: No existen eventos que contengan: " + s);
	}
}