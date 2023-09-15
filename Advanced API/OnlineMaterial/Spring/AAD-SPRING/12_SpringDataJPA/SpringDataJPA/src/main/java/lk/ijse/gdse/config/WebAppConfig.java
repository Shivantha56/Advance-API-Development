package lk.ijse.gdse.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
//@ComponentScan(basePackages = "lk.ijse.gdse")
public class WebAppConfig {

    public WebAppConfig() {
        System.out.println("This is the webAppconfig");
    }
}
