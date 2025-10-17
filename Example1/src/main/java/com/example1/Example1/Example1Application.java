package com.example1.Example1;

import beans.Vehicle;
import config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Example1Application {

	public static void main(String[] args) {
		SpringApplication.run(Example1Application.class, args);

        Vehicle vehicle = new Vehicle();
        vehicle.setName("Honda SH");
        vehicle.setBrand("Honda");
        vehicle.setModel("SH 125 2019");

        System.out.println("Il veicolo non registrato in un contesto di Spring è: \n" + vehicle.getName() + " " + vehicle.getBrand() + " " + vehicle.getModel());

        var context = new AnnotationConfigApplicationContext(Config.class);

        Vehicle veh = context.getBean(Vehicle.class);
        System.out.println("Il veicolo registrato in un contesto di Spring è: \n" + veh.getName() + " " + veh.getBrand() + " " + veh.getModel());
	}

}
