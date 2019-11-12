package br.com.evoluum.desafio.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.evoluum.desafio.model.Estado;

@Service
public class EndpointProvider {

	@Autowired
	private RestTemplate templete;
	
	@Autowired
	private Endpoint endpoint;
	
		public List<Estado> getAll() throws Exception {
			ResponseEntity<List<Estado>> response = 
					templete.exchange( endpoint.get("servicodados.ibge.api.estados"), HttpMethod.GET, null, new ParameterizedTypeReference<List<Estado>>() {}) ;
		    return response.getBody();
		}
		
		public  String get(final String  nomeCidade)  throws Exception {
			return nomeCidade;
		}

}
