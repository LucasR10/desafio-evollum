package br.com.evoluum.desafio.config;

public enum Tipo {

	 CSV(".csv"),ODT(".odt"),XML(".xml"),JSON(".json"),PDF(".pdf");
	
	private String formato;

	private Tipo(String ext) {
		formato = ext;
	}
	
	public String getFormato() {
		return formato;
	}
}
