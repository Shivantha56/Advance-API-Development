package lk.ijse.gdse.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@Configuration
@Import({JPAConfig.class})
public class WebRootConfig {
    public WebRootConfig() {
        System.out.println("This is the werootconfig");
    }
}
