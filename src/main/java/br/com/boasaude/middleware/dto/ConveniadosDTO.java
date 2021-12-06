package br.com.boasaude.middleware.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.boasaude.middleware.entities.Conveniado;

public class ConveniadosDTO {
	
	private List<Conveniado> conveniados;

	public List<Conveniado> getConveniados() {
		if (conveniados == null) {
			conveniados = new ArrayList<Conveniado>();
		}
		return conveniados;
	}

	public void setConveniados(List<Conveniado> conveniados) {
		this.conveniados = conveniados;
	}
}
