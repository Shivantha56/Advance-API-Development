package lk.ijse.gdse;

import lk.ijse.gdse.config.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();
        context.register(Configuration.class);
        context.refresh();
    }
}
