package br.com.evoluum.desafio.config;

import java.util.List;

public interface ExportadorRepository<T> {
	 public void  dados(List<T> dados );
	 public byte [] getBytes();
	 public String exportTo();
}
