package br.com.boasaude.middleware.integration;

import br.com.boasaude.middleware.dto.AssociadosDTO;
import br.com.boasaude.middleware.entities.Associado;

public class IntegrationSafMock {

	public AssociadosDTO execute() {
		AssociadosDTO associados = new AssociadosDTO();
		
		Associado associado = new Associado();
		associado.setId(10l);
		associado.setNome("Edson Adriano");
		
		associados.getAssociados().add(associado);
		return associados;
	}
}
