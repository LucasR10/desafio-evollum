package br.com.evoluum.desafio.resource;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
  
	@RequestMapping(value ="/")
	public void index(HttpServletResponse res) throws IOException {
		res.sendRedirect("/api/swagger-ui.html");
	}
}
