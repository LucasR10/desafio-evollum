package br.com.evoluum.desafio.arquivo;

import java.util.List;

public abstract class Arquivo<T>  implements InfoArquivo<T>{
	@SuppressWarnings("rawtypes")
	public abstract Arquivo addDados( List<T> dados );
}
