package com.example2.Example2;

import beans.Vehicle;
import config.VehicleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class Example2Application {

	public static void main(String[] args) {
		SpringApplication.run(Example2Application.class, args);

        var context = new AnnotationConfigApplicationContext(VehicleConfig.class);

        Vehicle veh1 = context.getBean("audiVehicle",Vehicle.class);
        System.out.println(veh1.getName());

        Vehicle veh2 = context.getBean("hondaVehicle",Vehicle.class);
        System.out.println(veh2.getName());

        Vehicle veh3 = context.getBean("fordVehicle",Vehicle.class);
        System.out.println(veh3.getName());
	}

}
