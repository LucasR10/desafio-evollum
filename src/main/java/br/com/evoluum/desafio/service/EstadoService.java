package br.com.evoluum.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evoluum.desafio.endpoint.EndpointProvider;
import br.com.evoluum.desafio.model.Estado;

@Service
public class EstadoService {

	@Autowired
	private EndpointProvider provider;
	
		public List<Estado> getAll() throws Exception {
			return provider.getAll();
		}
		
		public String getIdPorNomeCidade(final String nome) throws Exception {
			for (Estado es : provider.getAll()) {
				 if( es.getNome().equals(nome) ) return es.getId(); 
			}
			return "Cidade Não localizada" ;
		}

}
