package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.SpringBeanOne;
import lk.ijse.gdse.bean.SpringBeanTwo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = "lk.ijse.gdse.bean")
public class Configuration {

    @Bean
    public SpringBeanOne getSpringBeanOne(){
//        Inter bean dependencies
        SpringBeanTwo bean01 = getSpringBeanTwo();
        SpringBeanTwo bean02 = getSpringBeanTwo();
        System.out.println(bean01);
        System.out.println(bean02);
        return new SpringBeanOne();
    }
    @Bean
    public SpringBeanTwo getSpringBeanTwo(){
        return new SpringBeanTwo();
    }


}
