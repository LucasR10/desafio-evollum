package br.com.evoluum.service;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.evoluum.desafio.model.Estado;

@RunWith(SpringRunner.class)
class EstadoServiceTeste {
	
	private static final String URI = "http://www.mocky.io/v2/5dc989682f0000560073edbb";
	@Autowired
	private RestTemplate templete = new RestTemplate();
	
	@Test
	public void buscarEstados() throws Exception {
		templete.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		ResponseEntity<List<Estado>> response = templete.exchange( URI, HttpMethod.GET, null, new ParameterizedTypeReference<List<Estado>>() {});
		System.out.println( response.getBody() );
        assertTrue(  response.getStatusCode() == HttpStatus.OK);
     
	}
	

}
