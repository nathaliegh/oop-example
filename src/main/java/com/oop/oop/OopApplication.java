package com.oop.oop;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
@EnableMongock
public class OopApplication {


	public static void main(String[] args) {
		new SpringApplicationBuilder(OopApplication.class)
				.run(args);
	}

}
