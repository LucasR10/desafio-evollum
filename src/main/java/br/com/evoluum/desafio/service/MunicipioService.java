package br.com.evoluum.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evoluum.desafio.endpoint.EndpointProvider;
import br.com.evoluum.desafio.model.Municipio;

@Service
public class MunicipioService {

	
	@Autowired
	private EndpointProvider provider;
	
		public List<Municipio> getAll() throws Exception {
			return provider.getMunicipios();
		}
		
}
