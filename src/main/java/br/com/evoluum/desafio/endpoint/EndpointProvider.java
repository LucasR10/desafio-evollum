package br.com.evoluum.desafio.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.evoluum.desafio.model.Estado;
import br.com.evoluum.desafio.model.Municipio;

@Service
public class EndpointProvider {

	@Autowired
	private RestTemplate templete;
	
	@Autowired
	private Endpoint endpoint;
	
	    @Cacheable(value = "estados")
		public List<Estado> getEstados() throws Exception {
			ResponseEntity<List<Estado>> response = 
					templete.exchange( endpoint.get("servicodados.ibge.api.estados"), HttpMethod.GET, null, new ParameterizedTypeReference<List<Estado>>() {}) ;
		    return response.getBody();
		}
		
	    @Cacheable(value = "municipios")
		public List<Municipio> getMunicipios() throws Exception {
			ResponseEntity<List<Municipio>> response = 
					templete.exchange( endpoint.get("servicodados.ibge.api.municipios"), HttpMethod.GET, null, new ParameterizedTypeReference<List<Municipio>>() {}) ;
		    return response.getBody();
		}
		
		public List<Municipio> getMunicipios(String codigo) throws Exception {
			ResponseEntity<List<Municipio>> response = 
					templete.exchange( endpoint.get("servicodados.ibge.api.municipios").replace("{0}",codigo), HttpMethod.GET, null, new ParameterizedTypeReference<List<Municipio>>() {}) ;
		    return response.getBody();
		}
	

}
