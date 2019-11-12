package br.com.evoluum.desafio.config;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.ResourceUtils;

public class Configuration {

	
	 public void csv() throws FileNotFoundException, IOException {
		 List<List<String>> rows = Arrays.asList(
				    Arrays.asList("Jean", "author", "Java"),
				    Arrays.asList("David", "editor", "Python"),
				    Arrays.asList("Scott", "editor", "Node.js")
				);

				FileWriter csvWriter = new FileWriter(ResourceUtils.getFile("classpath:/csv/dados.csv"));
				csvWriter.append("Name");
				csvWriter.append(",");
				csvWriter.append("Role");
				csvWriter.append(",");
				csvWriter.append("Topic");
				csvWriter.append("\n");

				for (List<String> rowData : rows) {
				    csvWriter.append(String.join(",", rowData));
				    csvWriter.append("\n");
				}

				csvWriter.flush();
				csvWriter.close();
	 }
}
