package br.com.boasaude.middleware.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.boasaude.middleware.entities.Prestador;

public class PrestadoresDTO {
	
	private List<Prestador> prestadores;

	public List<Prestador> getPrestadores() {
		if (prestadores == null) {
			prestadores = new ArrayList<Prestador>();
		}
		return prestadores;
	}

	public void setAssociados(List<Prestador> prestadores) {
		this.prestadores = prestadores;
	}
}
