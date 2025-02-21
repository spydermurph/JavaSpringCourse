package is.webworks.config;

import is.webworks.Alien;
import is.webworks.Computer;
import is.webworks.Desktop;
import is.webworks.Laptop;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan("is.webworks")
public class AppConfig {

//    @Bean
//    //public Alien alien(@Qualifier("desktop") Computer computer)
//    public Alien alien(Computer computer){
//        Alien obj = new Alien();
//        obj.setAge(21);
//        obj.setComputer(computer);
//        return obj;
//    }
//
//    //@Bean(name = {"computer", "desktop1"})
//    @Bean
//    //@Scope("prototype")
//    public Desktop desktop(){
//        return new Desktop();
//    }
//
//    @Bean
//    @Primary
//    public Laptop laptop(){
//        return new Laptop();
//    }
}
