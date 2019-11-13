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

import br.com.evoluum.desafio.exportar.ExportarCSVMunicipio;
import br.com.evoluum.desafio.model.Municipio;
import br.com.evoluum.desafio.service.DownloadService;
import br.com.evoluum.desafio.service.MunicipioService;

@RestController
@RequestMapping(value ="/municipios")
public class MunicipioResource {

	@Autowired
	private MunicipioService municipioService;
	
	@Autowired
	private DownloadService downloadService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK )
	public ResponseEntity<List<Municipio>> exportarJson() throws Exception{
	   return  ResponseEntity.ok( municipioService.getAll() );
	}
	
	@RequestMapping(value = "/csv", method = RequestMethod.GET, produces = "text/csv")
	@ResponseStatus(code = HttpStatus.OK )
	public @ResponseBody void exportarCsv (HttpServletResponse response) throws Exception {
	    downloadService.download(new ExportarCSVMunicipio().addDados(municipioService.getAll())) ;
	}



	
}
