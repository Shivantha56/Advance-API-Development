package lk.ijse.gdse;

import lk.ijse.gdse.bean.MyConnection;
import lk.ijse.gdse.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.registerShutdownHook();
        ctx.register(AppConfig.class);
        ctx.refresh();

//        MyConnection bean = ctx.getBean(MyConnection.class);
//        System.out.println(bean);

//        ctx.destroy();
    }
}
