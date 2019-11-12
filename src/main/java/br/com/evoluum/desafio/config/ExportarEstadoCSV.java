package br.com.evoluum.desafio.config;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.evoluum.desafio.model.Estado;

@Component
public class ExportarEstadoCSV  extends ExportarCSV<Estado>{

	
	@Override
	public void dados(List<Estado> dados) {
		addCabecalho( "idEstado; siglaEstado ; regiaoNome; nomeCidade;nomeMesorregiao; nomeFormatado" );
	    for (Estado estado : dados) {
	    	 addLinha( estado.getId() )
	    	.addLinha( estado.getSigla())
	    	.addLinha( estado.getRegiao().getNome() )
	    	.addLinha( estado.getNome() )
	    	.addCabecalho( estado.getNomeFormatado() );
	      }
	}
}
