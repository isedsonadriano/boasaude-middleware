package br.com.boasaude.middleware.integration;

import br.com.boasaude.middleware.dto.AssociadosDTO;
import br.com.boasaude.middleware.dto.PrestadoresDTO;
import br.com.boasaude.middleware.entities.Associado;
import br.com.boasaude.middleware.entities.Prestador;

public class IntegrationSgpsMock {

	public PrestadoresDTO execute() {
		PrestadoresDTO prestadores = new PrestadoresDTO();
		
		Prestador prestador = new Prestador();
		prestador.setId(10l);
		prestador.setNome("Hospital Santa luzia");
		
		prestadores.getPrestadores().add(prestador);
		return prestadores;
	}
}
