package com.synerzip.springwithmongo.fakedata;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;
import com.synerzip.springwithmongo.model.Results;

public class MapReduce {
	@Autowired
	MongoTemplate mongoTemplate;

	public  String readFile(String path) throws FileNotFoundException,
			IOException {
		StringBuffer str = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(
				new ClassPathResource(path).getFile()));
		String line = br.readLine();
		while (line != null) {
			str.append(line);
			str.append("\n");
			line = br.readLine();
		}
		return str.toString();
	}

	public  void doMapReduce() throws FileNotFoundException, IOException{
		String map = readFile("map.js");
		String reduce = readFile("reduce.js");
		MapReduceResults<Results> results = mongoTemplate.mapReduce("products", map, reduce, Results.class);
		for (Results valueObject : results) {
		  System.out.println(valueObject);
		}
	}
}
