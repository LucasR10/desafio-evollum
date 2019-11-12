package br.com.evoluum.desafio.config;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DownloadService {

	@Autowired
	private HttpServletResponse response;
	
	public  void download( byte [] bytes, String name, Tipo tipo) throws IOException {
		response.setContentType("text/csv");
	    response.setHeader("Content-Disposition", "attachment; filename=\""+name+"\""+tipo.getFormato());
	    OutputStream outputStream = response.getOutputStream();
	    outputStream.write( bytes  );
        outputStream.flush();
        outputStream.close();
		
	}
	
	public  void download( byte [] bytes) throws IOException {
//		/download(bytes, "new_file.csv");
	}
}
