package br.com.evoluum.desafio.exportar;

import java.util.List;

import br.com.evoluum.desafio.arquivo.Arquivo;
import br.com.evoluum.desafio.arquivo.CsvFactory;
import br.com.evoluum.desafio.arquivo.TipoArquivo;
import br.com.evoluum.desafio.model.Municipio;


public class ExportarCSVMunicipio  extends CsvFactory<Municipio> {

	@Override
	public TipoArquivo getTipo() {
		return TipoArquivo.CSV;
	}


	@Override
	public String getNome() {
		return "cidade";
	}


	@Override
	public Arquivo<Municipio> addDados(List<Municipio> dados) {
		 dados.forEach( estado ->  {
			 addCabecalho( "idEstado; siglaEstado ; regiaoNome; nomeCidade;nomeMesorregiao; nomeFormatado" );
	    	 addColuna( "")
	    	.lineSeparator();
	   });
		return this;
	}

	
	

	
	
}
