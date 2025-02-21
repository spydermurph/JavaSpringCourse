package is.webworks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Alien {

    @Value("21")
    private int age;

    private Computer computer;

    public Alien(){
        System.out.println("Alien created");
    }

//    @ConstructorProperties({"age", "computer"})
//    public Alien(int age, Computer computer){
//        this.age = age;
//        this.computer = computer;
//        System.out.println("Constructor Object created");
//    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Computer getComputer() {
        return computer;
    }

    @Autowired
    @Qualifier("laptop")
    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public void code() {
        System.out.println("Coding");
        computer.compile();
    }
}
