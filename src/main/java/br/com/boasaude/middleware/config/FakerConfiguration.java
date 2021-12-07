package br.com.boasaude.middleware.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;


@Configuration
public class FakerConfiguration {

	@Bean
	public Faker getFaker() {
		return new Faker(new Locale("pt-BR"));
	}
}
