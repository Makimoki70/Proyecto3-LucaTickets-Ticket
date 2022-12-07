package com.proyecto.spring.ticket.model;

public enum Tipo {
	terraza("terraza"), interior("interior"), jardin("jardin");
	
	private String tipo;
	
	
	private Tipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}
}