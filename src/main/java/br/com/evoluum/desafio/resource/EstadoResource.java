package br.com.evoluum.desafio.resource;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.evoluum.desafio.config.DownloadService;
import br.com.evoluum.desafio.config.ExportarEstadoCSV;
import br.com.evoluum.desafio.model.Estado;
import br.com.evoluum.desafio.service.EstadoService;

@RestController
@RequestMapping(value ="/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private DownloadService download;
	
	
	@GetMapping 
	@ResponseStatus(code = HttpStatus.OK)
	public List<Estado>  getJson() throws Exception{
	   return estadoService.getAll();
	}
	
	@RequestMapping(value = "/csv", method = RequestMethod.GET, produces = "text/csv")
	public @ResponseBody void exportMailIdCsv(HttpServletResponse response) throws Exception {
	    ExportarEstadoCSV exporta = new ExportarEstadoCSV();
	    exporta.dados( estadoService.getAll() );
	   // download.download( exporta.getBytes(), "teste.csv") ;
	    
	}


	
}
