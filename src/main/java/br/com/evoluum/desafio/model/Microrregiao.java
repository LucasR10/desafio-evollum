package br.com.evoluum.desafio.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Microrregiao {
   private String id;
   private String nome;
   private Mesorregiao mesorregiao;
}
