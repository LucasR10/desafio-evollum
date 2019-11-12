package br.com.evoluum.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UF {
	private String id;
	private String sigla;
	private String nome;
    private Regiao regiao;
}
