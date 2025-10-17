package beans;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class Vehicle {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    /*
    L'annotazione @PostConstruct viene utilizzata in un metodo eseguito dopo la dependency injection
     */
    @PostConstruct
    public void initialize(){
        this.name = "Honda";
    }
    /*
    L'annotazione @PreDestroy viene utilzzata nel momento prima della distruzione del bean, in questo caso per
    garantire una pulizia all'interno del container
     */
    @PreDestroy
    public void destroy(){
        System.out.println("Distruggendo il bean Vehicle");
    }
}
