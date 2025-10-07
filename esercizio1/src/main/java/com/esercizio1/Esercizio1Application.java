package com.esercizio1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Esercizio1Application {

	public static void main(String[] args) {
		SpringApplication.run(Esercizio1Application.class, args);
	}

    @GetMapping //Rest end point method
    public String helloWorld() {
        return "Hello World! Spring Boot";
    }
}
