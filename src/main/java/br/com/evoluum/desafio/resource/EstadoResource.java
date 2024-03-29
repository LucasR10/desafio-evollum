package br.com.evoluum.desafio.resource;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.evoluum.desafio.exportar.ExportarCSVEstado;
import br.com.evoluum.desafio.model.Estado;
import br.com.evoluum.desafio.service.DownloadService;
import br.com.evoluum.desafio.service.EstadoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value ="/estados")
@Api(value = "Estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;
	
	@Autowired
	private DownloadService downloadService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK )
	@ApiOperation(value = "Retorna un json com o conjunto de Unidades da Federação do Brasil")
	public ResponseEntity<List<Estado>> exportarJson() throws Exception{
	   return  ResponseEntity.ok( estadoService.getAll() );
	}
	
	@RequestMapping(value = "/csv", method = RequestMethod.GET, produces = "text/csv")
	@ResponseStatus(code = HttpStatus.OK )
	@ApiOperation(value = "Retorna un csv com o conjunto de Unidades da Federação do Brasil")
	public @ResponseBody void exportarCsv (HttpServletResponse response) throws Exception {
	    downloadService.download( new ExportarCSVEstado().addDados(estadoService.getAll())) ;
	}



	
}
