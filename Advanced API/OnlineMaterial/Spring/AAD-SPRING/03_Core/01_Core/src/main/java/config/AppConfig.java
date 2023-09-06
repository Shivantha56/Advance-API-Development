package config;

import bean.SpringBeanOne;
import beans.Demo02;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {Demo02.class, SpringBeanOne.class})
public class AppConfig {
    public AppConfig(){
        System.out.println("This is the configuration class");
    }

}
