package br.com.evoluum.desafio.config;

public abstract class Exportador<T>  implements ExportadorRepository<T>{

  private StringBuilder sb = new StringBuilder();
  private String separator = ";";
  
	public Exportador<T> addLinha(String linha) {
		sb.append(linha).append(separator);
		return this;
	}
	
	public Exportador<T> addCabecalho(String linha) {
		sb.append(linha).append( System.lineSeparator() );
		return this;
	}

	protected String toCsv() {
		return sb.append(System.lineSeparator()).toString();
	}
}
