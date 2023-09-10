package lk.ijse.gdse;

import lk.ijse.gdse.bean.Boy;
import lk.ijse.gdse.config.Configuration;
import lk.ijse.gdse.di.Kamal;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.annotation.AnnotationConfigurationException;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();
        context.register(Configuration.class);
        context.refresh();
        Kamal bean = context.getBean(Kamal.class);
        System.out.println(bean);
        bean.chatWithKamali();
    }
}
