package br.com.evoluum.desafio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.evoluum.desafio.model.Estado;

@Service
public class EstadoService {

	@Autowired
	private RestTemplate restTemplate;
	
		public List<Estado> getAll() throws Exception {
		    ResponseEntity<List<Estado>> response = restTemplate.exchange("http://www.mocky.io/v2/5dc989682f0000560073edbb", HttpMethod.GET, null, new ParameterizedTypeReference<List<Estado>>() {});
		    return response.getBody();
		}

}
