package com.example5.Example5;

import beans.Vehicle;
import config.VehicleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Example5Application {

	public static void main(String[] args) {
		SpringApplication.run(Example5Application.class, args);

        var context = new AnnotationConfigApplicationContext(VehicleConfig.class);
        Vehicle vehicle = context.getBean(Vehicle.class); //Richiamo della funzione initialize nel contesto

        System.out.println("Component Vehicle nel contesto di Spring: " + vehicle.getName());

        context.close(); //Richiamo della funzione destroy nel contesto
	}

}
