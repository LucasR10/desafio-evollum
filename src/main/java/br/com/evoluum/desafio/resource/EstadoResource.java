package br.com.evoluum.desafio.resource;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value ="/estados")
public class EstadoResource {

	@GetMapping
	public String  estados(){
	   return "ola";
	}
	
}
