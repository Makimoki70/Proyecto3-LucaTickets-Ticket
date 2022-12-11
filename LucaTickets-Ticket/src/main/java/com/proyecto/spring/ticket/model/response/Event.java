package com.proyecto.spring.ticket.model.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Event implements Serializable {

private static final long serialVersionUID = 1L;
	
	private String nombre, corta, extendida, foto, normas;
	private LocalDate fecha;
	private LocalTime hora, minimo, maximo;
	private Double precio;
	private Recinto sala;
	
}