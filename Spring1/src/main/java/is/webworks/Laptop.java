package is.webworks;

import org.springframework.stereotype.Component;

@Component
public class Laptop implements Computer {
    public Laptop() {
        System.out.println("Laptop created");
    }

    @Override
    public void compile(){
        System.out.println("Compiling using laptop");
    }
}
