package br.com.evoluum.desafio.service;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.evoluum.desafio.arquivo.Arquivo;
import br.com.evoluum.desafio.arquivo.TipoArquivo;

@Service
public class DownloadService {

	@Autowired
	private HttpServletResponse response;
	
	private  void download( byte [] bytes, final String name, TipoArquivo tipo) throws IOException {
		response.setContentType("text/" + tipo.getExtensao() );
	    response.setHeader("Content-Disposition", "attachment; filename=\""+name+"\"."+tipo.getExtensao());
	    OutputStream outputStream = response.getOutputStream();
	    outputStream.write( bytes  );
        outputStream.flush();
        outputStream.close();
	}

	@SuppressWarnings("rawtypes")
	public void download( Arquivo arquivo) throws IOException {
		download( arquivo.getBytes(), arquivo.getNome(), arquivo.getTipo() );
	}
	

}
