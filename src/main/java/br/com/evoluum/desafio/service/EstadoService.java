package br.com.evoluum.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.evoluum.desafio.model.Estado;

@Service
public class EstadoService {

	@Autowired
	private RestTemplate restTemplate;
	
	public List<Estado> getAll(){
		 return null;
	}

}
