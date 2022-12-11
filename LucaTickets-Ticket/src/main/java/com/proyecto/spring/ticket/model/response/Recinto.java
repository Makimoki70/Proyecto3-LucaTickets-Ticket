package com.proyecto.spring.ticket.model.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Data
public class Recinto {
	private String nombre, ciudad, direccion;
	private Tipo tipoRecinto;
	private int aforo;
}
