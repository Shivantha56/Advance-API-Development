package bean;

import org.springframework.stereotype.Component;

@Component("BeanTwo")
public class SpringBeanTwo {
    public SpringBeanTwo() {
        System.out.println("Spring bean 02");
    }
}
