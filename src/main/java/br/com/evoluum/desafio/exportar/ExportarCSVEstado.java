package br.com.evoluum.desafio.exportar;

import java.util.List;

import br.com.evoluum.desafio.arquivo.Arquivo;
import br.com.evoluum.desafio.arquivo.CsvFactory;
import br.com.evoluum.desafio.arquivo.TipoArquivo;
import br.com.evoluum.desafio.model.Estado;


public class ExportarCSVEstado  extends CsvFactory<Estado> {

	@Override
	public TipoArquivo getTipo() {
		return TipoArquivo.CSV;
	}


	@Override
	public String getNome() {
		return "estados";
	}

	@Override
	public Arquivo<Estado> addDados(List<Estado> dados) {
		 dados.forEach( estado ->  {
			 addCabecalho( "idEstado; siglaEstado ; regiaoNome; nomeCidade;nomeMesorregiao; nomeFormatado" );
	    	 addColuna( estado.getId() )
	    	.addColuna( estado.getSigla() )
	    	.addColuna( estado.getRegiao().getNome() )
	    	.addColuna( estado.getNome() )
	    	.addColuna( "" )
	    	.addColuna( estado.getNomeFormatado() )
	    	.lineSeparator();
	   });
		return this;
	}


	

	
	
}
