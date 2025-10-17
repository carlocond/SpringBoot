package com.example3.Example3;

import beans.Vehicle;
import config.VehicleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Example3Application {

	public static void main(String[] args) {
		SpringApplication.run(Example3Application.class, args);

        var context = new AnnotationConfigApplicationContext(VehicleConfig.class);

        Vehicle vehicle = context.getBean(Vehicle.class);
        System.out.println("Nome del bean con annotazione @Primary: " + vehicle.getName());
	}

}
