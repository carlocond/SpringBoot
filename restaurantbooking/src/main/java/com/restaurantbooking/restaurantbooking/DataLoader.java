package com.restaurantbooking.restaurantbooking;

import Model.ETable;
import Repository.TableRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner seedTables(TableRepository tableRepository){
        return args -> {
            if (tableRepository.count() == 0) {
                ETable t1 = new ETable();
                t1.setName("Tavolo 1");
                t1.setSeats(2);

                ETable t2 = new ETable();
                t2.setName("Tavolo 2");
                t2.setSeats(4);

                ETable t3 = new ETable();
                t3.setName("Tavolo 3");
                t3.setSeats(6);

                tableRepository.save(t1);
                tableRepository.save(t2);
                tableRepository.save(t3);
            }
        };
    }
}
