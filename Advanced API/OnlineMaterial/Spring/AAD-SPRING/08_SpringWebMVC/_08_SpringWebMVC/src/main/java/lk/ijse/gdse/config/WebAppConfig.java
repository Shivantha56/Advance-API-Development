package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.SpringBean01;
import lk.ijse.gdse.controller.ControllerOne;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackageClasses = {ControllerOne.class, SpringBean01.class})
@EnableWebMvc
public class WebAppConfig {
}
