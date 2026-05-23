package com.zchadli.task_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;

@SpringBootApplication
public class TaskBackendApplication {

	@Autowired
	private Environment env;

	public static void main(String[] args) {
		SpringApplication.run(TaskBackendApplication.class, args);
	}
}
