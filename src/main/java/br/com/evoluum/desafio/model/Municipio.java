package br.com.evoluum.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Municipio {
 
private Microrregiao microrregiao;
private Mesorregiao mesorregiao;
private UF uf;
private Regiao regiao;
}
