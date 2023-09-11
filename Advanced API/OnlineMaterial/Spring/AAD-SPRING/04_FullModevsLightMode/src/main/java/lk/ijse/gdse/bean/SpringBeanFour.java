package lk.ijse.gdse.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanFour {
    public SpringBeanFour() {
        System.out.println("Spring bean four  initaited");
    }

    @Bean
    public SpringBeanThree getSpringBeanThree(SpringBeanTwo springBeanTwo){
        System.out.println(springBeanTwo);
        System.out.println(springBeanTwo);
        return new SpringBeanThree();
    }

    @Bean
    public SpringBeanTwo getSpringBeanTwo(){
        return new SpringBeanTwo();
    }



}
