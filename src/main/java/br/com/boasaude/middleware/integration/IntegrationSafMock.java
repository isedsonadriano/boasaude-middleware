package br.com.boasaude.middleware.integration;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.com.boasaude.middleware.dto.AssociadosDTO;
import br.com.boasaude.middleware.entities.Associado;
import br.com.boasaude.middleware.util.UtilCpf;

public class IntegrationSafMock {
	
	private static final int QUANTIDADE_ASSOCIADOS_DUMP = 50;

	public AssociadosDTO execute() {

		AssociadosDTO associados = new AssociadosDTO();

		Faker faker = new Faker(new Locale("pt-BR"));
		for (int i = 0; i < QUANTIDADE_ASSOCIADOS_DUMP; i++) {
			Associado associado = new Associado();
			associado.setNome(faker.name().fullName());
			associado.setNomeDaMae(faker.name().fullName());
			associado.setCpf(new UtilCpf().cpf(true));
			associado.setNumeroCarteira(String.valueOf(faker.random().nextLong(123456789)));
			associado.setRg(String.valueOf(faker.random().nextLong(123456789)));
			associado.setTitular(Boolean.TRUE);
			associado.setTelefone("(61)982770004 ");
			associados.getAssociados().add(associado);
		}

		return associados;

	}
}
