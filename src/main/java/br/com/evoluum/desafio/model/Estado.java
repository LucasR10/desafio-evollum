package br.com.evoluum.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@AllArgsConstructor @ToString
public class Estado {
    private String sigla;
    private String nome;
    private String id;
    private Regiao regiao;
}
