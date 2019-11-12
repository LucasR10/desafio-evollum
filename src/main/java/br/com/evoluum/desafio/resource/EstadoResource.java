package br.com.evoluum.desafio.resource;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.validator.internal.util.classhierarchy.Filters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.evoluum.desafio.model.Estado;
import br.com.evoluum.desafio.service.EstadoService;

@RestController
@RequestMapping(value ="/estados")
public class EstadoResource {

	@Autowired
	private EstadoService estadoService;
	
	@GetMapping 
	@ResponseStatus(code = HttpStatus.OK)
	public List<Estado>  get() throws Exception{
	   return estadoService.getAll();
	}
	
	
	@GetMapping(value = "/nome") 
	@ResponseStatus(code = HttpStatus.OK)
	public String  getPorNome( @PathVariable String nome) throws Exception{
	   return estadoService.getIdPorNomeCidade(nome);
	}
	
	@RequestMapping(value = "/csv", method = RequestMethod.GET, produces = "text/csv")
	public @ResponseBody String exportMailIdCsv() throws Exception {

	    List<Estado> eblnotif_list = estadoService.getAll();
	    StringBuilder sb = exportToCsv( eblnotif_list );
	    return sb.toString();
	}


	private StringBuilder exportToCsv(List<Estado> eblnotif_list) {
		String separator = ";";
	    StringBuilder sb = new StringBuilder();
	    sb.append("idEstado; siglaEstado ; regiaoNome; nomeCidade;nomeMesorregiao;nomeFormatado").append( System.lineSeparator() );
	    for (Estado eblNotif : eblnotif_list) {
	    	sb.append( eblNotif.getId() ).append(separator);
	        sb.append( eblNotif.getSigla() ).append(separator);
            sb.append( eblNotif.getRegiao().getNome() ).append(separator);
            sb.append( eblNotif.getNome() ).append(separator);
            sb.append( "nomeMesorregiao" ).append(separator);
            sb.append( eblNotif.getNomeFormatado() ).append(separator);
	        sb.append( System.lineSeparator()) ;
	    }
		return sb;
	}

}
