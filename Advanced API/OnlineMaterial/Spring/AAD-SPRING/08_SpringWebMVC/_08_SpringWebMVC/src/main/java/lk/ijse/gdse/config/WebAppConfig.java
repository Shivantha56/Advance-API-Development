package lk.ijse.gdse.config;

import lk.ijse.gdse.bean.SpringBean01;
import lk.ijse.gdse.controller.ControllerOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackageClasses = {ControllerOne.class, SpringBean01.class})
@EnableWebMvc
public class WebAppConfig implements WebMvcConfigurer {
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver view =new InternalResourceViewResolver();
        view.setPrefix("/view/");
        view.setSuffix(".html");
        view.setOrder(2);
        return view;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/view/*").addResourceLocations("/view/");
    }
}
