package br.com.evoluum.desafio.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration 
@PropertySource("classpath:endpoint.properties")
class Endpoint {

	@Autowired
	private Environment env;

	public String get(final String key) {
	    return env.getProperty(key);
	}
	

}
