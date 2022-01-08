package br.com.boasaude.middleware.integration;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.com.boasaude.middleware.dto.ConveniadosDTO;
import br.com.boasaude.middleware.entities.Conveniado;
import br.com.boasaude.middleware.util.UtilGeradorNumeroAleatorio;

public class IntegrationSasMock {
	
	private static final int QUANTIDADE_CONVENIADOS_DUMP = 50;

	public ConveniadosDTO execute() {

		ConveniadosDTO conveniados = new ConveniadosDTO();

		Faker faker = new Faker(new Locale("pt-BR"));
		for (int i = 0; i < QUANTIDADE_CONVENIADOS_DUMP; i++) {
			Conveniado conveniado = new Conveniado();
			conveniado.setId(faker.random().nextLong(123456789));
			conveniado.setNome(faker.name().fullName());
<<<<<<< HEAD
			conveniado.setCpf(String.valueOf(faker.random().nextLong()));
=======
>>>>>>> branch 'master' of git@github.com:isedsonadriano/boasaude-middleware.git
			conveniado.setCnpj(new UtilGeradorNumeroAleatorio().cnpj(true));
			conveniados.getConveniados().add(conveniado);
		}

		return conveniados;

	}

}
