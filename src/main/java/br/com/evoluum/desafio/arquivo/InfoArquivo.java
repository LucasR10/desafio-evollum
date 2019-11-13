package br.com.evoluum.desafio.arquivo;

public interface InfoArquivo<T> {
	 public byte [] getBytes();
	 public TipoArquivo getTipo();
	 public String getNome();
}
