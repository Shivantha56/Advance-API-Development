package config;

import bean.MyConnection;
import bean.SpringBeanOne;
import beans.Demo02;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//Bean definition source
@Configuration
//@ComponentScan(basePackageClasses = {Demo02.class, SpringBeanOne.class})
@ComponentScan(basePackages = "bean")
public class AppConfig {
    public AppConfig(){
        System.out.println("This is the configuration class");
    }

    @Bean("myBean")
    public MyConnection getConnection(){
        return new MyConnection();
    }

}
