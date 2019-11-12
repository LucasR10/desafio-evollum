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
	
	public  void download( byte [] bytes, String name) throws IOException {
		response.setContentType("text/csv");
	    response.setHeader("Content-Disposition", "attachment; filename=\""+name+"\"");
	    OutputStream outputStream = response.getOutputStream();
	    outputStream.write( bytes  );
        outputStream.flush();
        outputStream.close();
		
	}
}
