package lk.ijse.gdse;

import lk.ijse.gdse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerShutdownHook();
        ctx.register(AppConfig.class);
        ctx.refresh();
    }
}
