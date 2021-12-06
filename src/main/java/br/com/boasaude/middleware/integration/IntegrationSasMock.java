package br.com.boasaude.middleware.integration;

import br.com.boasaude.middleware.dto.ConveniadosDTO;
import br.com.boasaude.middleware.entities.Conveniado;

public class IntegrationSasMock {

	public ConveniadosDTO execute() {
		ConveniadosDTO conveniados = new ConveniadosDTO();
		
		Conveniado conveniado = new Conveniado();
		conveniado.setId(10l);
		conveniado.setNome("Dr. João");
		
		conveniados.getConveniados().add(conveniado);
		return conveniados;
	}
}
