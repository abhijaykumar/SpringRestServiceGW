package com.centric;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringGwApplication extends SpringBootServletInitializer {

	public static void main(String... args) {
		SpringApplication.run(SpringGwApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return  builder.sources(SpringGwApplication.class);
	}

	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Spring Boot REST Web service!";
	}
}
