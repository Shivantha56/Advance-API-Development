package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.Bean02;
import lk.ijse.gdse.bean.Bean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {

    @Bean
    public Bean1 getBean01(){
        return new Bean1();
    }

    @Bean
    public Bean02 getBean02(){
        return new Bean02();
    }



}
