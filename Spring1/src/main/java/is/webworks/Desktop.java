package is.webworks;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component("computer1") //name of bean
@Component
@Primary
@Scope("prototype")
public class Desktop implements Computer{
    public Desktop() {
        System.out.println("Desktop created");
    }

    @Override
    public void compile() {
        System.out.println("Compiling using desktop");
    }
}
