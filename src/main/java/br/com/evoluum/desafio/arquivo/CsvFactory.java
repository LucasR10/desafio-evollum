package br.com.evoluum.desafio.arquivo;

public abstract class CsvFactory<T>  extends Arquivo<T>{
	
	private StringBuilder sb = new StringBuilder();
	private String separator = ";";


	public CsvFactory<T> addColuna(String linha) {
		sb.append(linha).append( separator );
		return this;
	}

	public CsvFactory<T> addCabecalho(String linha) {
		sb.append(linha).append( System.lineSeparator() );
		return this;
	}

	@Override
	public byte[] getBytes() {
		return text().getBytes();
	}

	public String text() {
		return sb.append( System.lineSeparator()).toString();
	}

	public CsvFactory<T> lineSeparator() {
		sb.append(System.lineSeparator());
	  return this;
	}

}
