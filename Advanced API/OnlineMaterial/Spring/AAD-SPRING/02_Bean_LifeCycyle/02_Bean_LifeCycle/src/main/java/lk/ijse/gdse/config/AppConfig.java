package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.MyConnection;
import lk.ijse.gdse.bean.SpringBen01;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration()
@ComponentScan(basePackageClasses = SpringBen01.class)
public class AppConfig {

    @Bean
//    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public MyConnection getConnection(){
        return new MyConnection();
    }

}
