package config;

import beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
/*
L'annotazione @ComponentScan serve per far capire a Spring in quale package cercare e registrare i bean
Con essa cercherà tutte le classi che all'interno del package specificato avranno annotazioni come @Component, @Repository,
@Service, @Controller, ecc...
 */
@ComponentScan(basePackages = "beans")
public class VehicleConfig {

    Vehicle vehicle(){
        Vehicle veh = new Vehicle();
        veh.setName("MVAGUSTA");
        return veh;
    }

}
