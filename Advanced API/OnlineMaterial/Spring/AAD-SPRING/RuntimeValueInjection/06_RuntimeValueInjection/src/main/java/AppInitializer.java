import lk.ijse.gdse.config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.registerShutdownHook();
        context.register(AppConfiguration.class);
        context.refresh();
    }

}
