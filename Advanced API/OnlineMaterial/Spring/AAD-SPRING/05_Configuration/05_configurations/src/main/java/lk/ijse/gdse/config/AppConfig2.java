package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.Bean03;

import lk.ijse.gdse.bean.Bean04;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig2 {
    @Bean
    public Bean03 getBean03(){
        return new Bean03();
    }

    @Bean
    public Bean04 getBean04(){
        return new Bean04();
    }
}
