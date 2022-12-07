package com.proyecto.spring.ticket.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Ticket {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	private User idUser;
	private Event idEvent;
	private double precio;
	
}