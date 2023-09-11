package lk.ijse.gdse;

import lk.ijse.gdse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;
import java.util.Properties;

public class AppInitializer {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerShutdownHook();
        ctx.register(AppConfig.class);
        ctx.refresh();

//        get system variable
//        System.getenv();
//        Map<String, String> getenv = System.getenv();
//        for (String key: getenv.keySet()) {
//            System.out.println(key+" : "+getenv.get(key));
//        }

        //get java environmental variable
//        System.getProperty()

//        Properties properties = System.getProperties();
//        for (Object key : properties.keySet()){
//            System.out.println(key+" : "+properties.get(key));
//        }
    }
}
