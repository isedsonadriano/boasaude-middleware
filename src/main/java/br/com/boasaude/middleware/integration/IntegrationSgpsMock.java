package br.com.boasaude.middleware.integration;

import java.util.Locale;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import br.com.boasaude.middleware.dto.PrestadoresDTO;
import br.com.boasaude.middleware.entities.Prestador;

@Component
public class IntegrationSgpsMock {

	private static final int QUANTIDADE_PRESTADORES_DUMP = 50;

	public PrestadoresDTO execute() {

		PrestadoresDTO prestadores = new PrestadoresDTO();

		Faker faker = new Faker(new Locale("pt-BR"));
		for (int i = 0; i < QUANTIDADE_PRESTADORES_DUMP; i++) {
			Prestador prestador = new Prestador();
			prestador.setId(faker.random().nextLong(123456789));
			prestador.setNome(faker.company().name());
			prestador.setCpf(String.valueOf(faker.random().nextLong()));
			prestadores.getPrestadores().add(prestador);
		}

		return prestadores;

	}
}
