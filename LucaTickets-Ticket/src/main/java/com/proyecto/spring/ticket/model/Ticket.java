package com.proyecto.spring.ticket.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity(name="ticket")
@Table(name = "ticket")
public class Ticket {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="iduser")
	private long iduser;
	@Column(name="idevent")
	private long idevent;
	@Column(name="precio")
	private double precio;
}