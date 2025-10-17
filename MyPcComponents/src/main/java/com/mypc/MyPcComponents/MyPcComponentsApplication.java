package com.mypc.MyPcComponents;

import com.mypc.MyPcComponents.model.Component;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.mypc.MyPcComponents.repository.ComponentRepository;

@SpringBootApplication(scanBasePackages = "com.mypc.MyPcComponents")
@EnableJpaRepositories(basePackages = "com.mypc.MyPcComponents.repository")
@EntityScan(basePackages = "com.mypc.MyPcComponents.model")

public class MyPcComponentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyPcComponentsApplication.class, args);
    }

    @Bean
    CommandLineRunner init(ComponentRepository repo) {
        return args -> {
            repo.save(Component.builder()
                    .name("Intel Core i7-14700F")
                    .type("CPU")
                    .brand("Intel")
                    .model("i7-14700F")
                    .specs("20 cores, 28 threads, 5.4GHz")
                    .build());
            repo.save(Component.builder()
                    .name("NVIDIA RTX 5070")
                    .type("GPU")
                    .brand("Zotac Gaming")
                    .model("5070 SOLID OC")
                    .specs("12GB VRAM, 6144 Cores, GDDR7")
                    .build());
            repo.save(Component.builder()
                    .name("PRO Z790-P WIFI")
                    .type("MotherBoard")
                    .brand("MSI")
                    .model("PRO Z790-P WIFI")
                    .specs("DDR5, Chipset Intel, Wi-fi")
                    .build());
            repo.save(Component.builder()
                    .name("Zalman ALPHA2")
                    .type("AIO")
                    .brand("Zalman")
                    .model("Alpha2 A24")
                    .specs("240mm, 2 ARGBFans, Liquid Cooler")
                    .build());
            repo.save(Component.builder()
                    .name("Crucial Pro RAM")
                    .type("RAM")
                    .brand("Crucial")
                    .model("Crucial Pro")
                    .specs("32GB, 6000MHz, XMP 3.0")
                    .build());
            repo.save(Component.builder()
                    .name("Musetex Y6W")
                    .type("Case")
                    .brand("Musetex")
                    .model("Y6 White")
                    .specs("Full view, ATX, White")
                    .build());
            repo.save(Component.builder()
                    .name("Crucial T500 SSD")
                    .type("SSD")
                    .brand("Crucial")
                    .model("T500")
                    .specs("NVMe M.2, 7300MB/s, Gen4")
                    .build());
        };
    }
}