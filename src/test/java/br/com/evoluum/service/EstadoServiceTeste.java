package br.com.evoluum.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import br.com.evoluum.desafio.service.EstadoService;

@RunWith(SpringRunner.class)
class EstadoServiceTeste {

	@Autowired
	private EstadoService service;
	
	@Autowired
	private RestTemplate templete = new RestTemplate();
	
	@Test
	public void buscarEstados() {
		ResponseEntity<Object[]> responseEntity = templete.getForEntity("https://servicodados.ibge.gov.br/api/v1/localidades/estados", Object[].class);
		Object[] objects = responseEntity.getBody();
		MediaType contentType = responseEntity.getHeaders().getContentType();
		HttpStatus statusCode = responseEntity.getStatusCode();
	   
		ResponseEntity<String> txt = templete.getForEntity("https://servicodados.ibge.gov.br/api/v1/localidades/estados", String.class);
		
		System.out.println( txt.getBody() );
	}

}
