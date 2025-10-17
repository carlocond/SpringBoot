package config;

import beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
L'annotazione @Configuration indica che all'interno della classe
verranno definiti degli oggetti (bean) gestiti dal container di
Spring
 */

@Configuration
public class Config {

    /*
    L'annotazione @Bean serve per definire un metodo
    che crea un oggetto (un bean) che deve essere registrato
    e gestito nel container di Spring
     */

    @Bean
    Vehicle vehicle(){
        var veh = new Vehicle();
        veh.setName("Audi RSQ8");
        veh.setBrand("Audi");
        veh.setModel("RSQ8");
        return veh;
    }




}
