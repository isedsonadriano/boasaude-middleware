package br.com.boasaude.middleware.integration;

import java.util.Locale;

import org.springframework.stereotype.Component;

import com.github.javafaker.Faker;

import br.com.boasaude.middleware.dto.PrestadoresDTO;
import br.com.boasaude.middleware.entities.Prestador;
import br.com.boasaude.middleware.util.UtilGeradorNumeroAleatorio;

@Component
public class IntegrationSgpsMock {

	private static final int QUANTIDADE_PRESTADORES_DUMP = 50;

	public PrestadoresDTO execute() {

		PrestadoresDTO prestadores = new PrestadoresDTO();

		Faker faker = new Faker(new Locale("pt-BR"));
		for (int i = 0; i < QUANTIDADE_PRESTADORES_DUMP; i++) {
			Prestador prestador = new Prestador();
			prestador.setNome(faker.name().fullName());
			prestador.setCpf(new UtilGeradorNumeroAleatorio().cpf(true));
			prestadores.getPrestadores().add(prestador);
		}

		return prestadores;

	}
}
