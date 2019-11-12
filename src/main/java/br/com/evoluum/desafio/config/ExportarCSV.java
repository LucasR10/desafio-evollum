package br.com.evoluum.desafio.config;

public abstract class ExportarCSV<T> extends Exportador<T> {
    
	@Override
	public byte[] getBytes() {
		return exportTo().getBytes();
	}

	@Override
	public String exportTo() {
		return toCsv();
	}


}
