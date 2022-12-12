package com.proyecto.spring.ticket.model.response;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nombre;	
	private String apellido;
	private String mail;
	private String pass;
	private Date fecha_alta;
}
