package lk.ijse.gdse;

import lk.ijse.gdse.config.AppConfig;
import lk.ijse.gdse.config.AppConfig1;
import lk.ijse.gdse.config.AppConfig2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerShutdownHook();
        ctx.register(AppConfig.class,AppConfig1.class,AppConfig2.class);
        ctx.register(AppConfig1.class,AppConfig1.class,AppConfig.class);
        ctx.refresh();
    }
}
