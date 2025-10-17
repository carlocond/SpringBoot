package config;

import beans.Vehicle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class VehicleConfig {

    @Bean(name = "audiVehicle")
    Vehicle vehicle1() {
        var veh = new Vehicle();
        veh.setName("Audi");
        return veh;
    }
    @Bean(name = "hondaVehicle")
    Vehicle vehicle2() {
        var veh = new Vehicle();
        veh.setName("Honda");
        return veh;
    }
    /*
    L'annotazione @Primary serve a fare in modo che in caso di stato confusionale a causa della presenza
    di molteplici beans, Spring selezioni quello primario di default;
    Principalmente nel momento in cui non viene specificato il nome di un bean in caso di più opzioni
     */
    @Primary
    @Bean("ferrariVehicle")
    Vehicle vehicle3() {
        var veh = new Vehicle();
        veh.setName("Ferrari");
        return veh;
    }
}
