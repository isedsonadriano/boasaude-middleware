package br.com.boasaude.middleware.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Associado {
	
	private Long id;
	private String nome;
	private String cpf;
	private String numeroCarteira;
	private String dataNascimento;
	private String rg;
	private String nomeDaMae;
	private String telefone;
	private String tipoPlano;
	private Boolean titular;
	
}
