package config;

import beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class VehicleConfig {

    /*
    Questo è un modo alternativo per dare un nome ad un bean, nonostante l'utilizzo della variabile var veh presente in ogni bean
    esso verrà riconosciuto dal valore assegnatogli come nome: @Bean(name = "*nome*")
     */

    @Bean(name = "audiVehicle")
    Vehicle vehicle1(){
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }
    @Bean(name = "hondaVehicle")
    Vehicle vehicle2(){
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }
    @Bean(name = "fordVehicle")
    Vehicle vehicle3(){
        var veh = new Vehicle();
        veh.setName("Ford");
        return veh;
    }


}
