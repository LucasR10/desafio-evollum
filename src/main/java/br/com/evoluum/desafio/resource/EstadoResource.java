package br.com.evoluum.desafio.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.evoluum.desafio.model.Estado;
import br.com.evoluum.desafio.service.EstadoService;

@RestController
@RequestMapping(value ="/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping @ResponseStatus(code = HttpStatus.OK)
	public List<Estado>  getAll() throws Exception{
	   return estadoService.getAll();
	}
	
}
