package br.com.evoluum.desafio.arquivo;

import lombok.Getter;

public enum TipoArquivo {

	CSV("csv"),ODT("odt"),XML("xml"),JSON("json"),PDF("pdf");
	
	@Getter
	private String extensao;

	private TipoArquivo(String ext) {
		extensao = ext;
	}
	
}
