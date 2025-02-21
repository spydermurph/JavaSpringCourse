package is.webworks;

import is.webworks.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Alien obj1 = context.getBean(Alien.class);
        obj1.code();
        //obj1.setAge(21);
        System.out.println(obj1.getAge());

        //Desktop desktop = context.getBean("desktop", Desktop.class);
//        Desktop desktop = context.getBean(Desktop.class);
//        desktop.compile();
//
//        Desktop desktop1 = context.getBean(Desktop.class);
//        desktop1.compile();

//        Xml based config
//        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
////        Alien obj1 = (Alien)context.getBean("alien");
//        Alien obj1 = context.getBean("alien", Alien.class);
//        //obj1.code();
//        //obj1.setAge(21);
//        System.out.println(obj1.getAge());
//        obj1.code();
//
//        Desktop desktop = context.getBean(Desktop.class);
////        Alien obj2 = (Alien)context.getBean("alien");
////        System.out.println(obj2.age);
    }
}
