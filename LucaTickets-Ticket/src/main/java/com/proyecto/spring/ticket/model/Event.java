package com.proyecto.spring.ticket.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import com.proyecto.spring.ticket.model.Event;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
public class Event{

	@Id
	public Long id;
	
	private String nombre, corta, extendida, foto, normas;
	private LocalDate fecha;
	private LocalTime hora, minimo, maximo;
	private Double precio;
	private Recinto sala;
}