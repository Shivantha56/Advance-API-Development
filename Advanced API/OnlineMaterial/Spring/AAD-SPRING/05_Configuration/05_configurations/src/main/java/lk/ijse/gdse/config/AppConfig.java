package lk.ijse.gdse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

//A source for bean definition
@Configuration
@ComponentScan(basePackages = "lk.ijse.gdse.bean")
@Import({AppConfig1.class,AppConfig2.class})
//@ImportResource("classpath:abcd.xml")
//@ImportResource("file:e.xml")
public class AppConfig {

}
