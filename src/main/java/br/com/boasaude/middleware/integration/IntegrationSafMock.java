package br.com.boasaude.middleware.integration;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.com.boasaude.middleware.dto.AssociadosDTO;
import br.com.boasaude.middleware.entities.Associado;
import br.com.boasaude.middleware.util.UtilGeradorNumeroAleatorio;

public class IntegrationSafMock {
	
	private static final int QUANTIDADE_ASSOCIADOS_DUMP = 50;

	public AssociadosDTO execute() {

		AssociadosDTO associados = new AssociadosDTO();

		Faker faker = new Faker(new Locale("pt-BR"));
		for (int i = 0; i < QUANTIDADE_ASSOCIADOS_DUMP; i++) {
			Associado associado = new Associado();
			associado.setNome(faker.company().name());
			associado.setNomeDaMae(faker.name().fullName());
			associado.setCpf(new UtilGeradorNumeroAleatorio().cpf(true));
			associado.setNumeroCarteira(String.valueOf(faker.random().nextLong(123456789)));
			associado.setRg(new UtilGeradorNumeroAleatorio().rg(true));
			associado.setTitular(Boolean.TRUE);
			associado.setTelefone("(61) 98277-0004");
			associados.getAssociados().add(associado);
		}

		return associados;

	}
}
