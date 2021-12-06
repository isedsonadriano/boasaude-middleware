package br.com.boasaude.middleware.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.boasaude.middleware.entities.Associado;

public class AssociadosDTO {
	
	private List<Associado> associados;

	public List<Associado> getAssociados() {
		if (associados == null) {
			associados = new ArrayList<Associado>();
		}
		return associados;
	}

	public void setAssociados(List<Associado> associados) {
		this.associados = associados;
	}
}
