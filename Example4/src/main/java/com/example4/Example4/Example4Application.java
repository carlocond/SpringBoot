package com.example4.Example4;

import beans.Vehicle;
import config.VehicleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Example4Application {

	public static void main(String[] args) {
		SpringApplication.run(Example4Application.class, args);

        var context = new AnnotationConfigApplicationContext(VehicleConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Questo bean è un component all'interno del contesto di Spring: " + vehicle.getName());
	}

}
