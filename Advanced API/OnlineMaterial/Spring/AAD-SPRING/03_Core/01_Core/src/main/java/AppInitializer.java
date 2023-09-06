import bean.SpringBeanOne;
import bean.SpringBeanThree;
import bean.SpringBeanTwo;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext anc = new AnnotationConfigApplicationContext();

//        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("JVM is about ot end");
//                anc.close();
//            }
//        }));

        anc.registerShutdownHook();

        anc.register(AppConfig.class);
        anc.refresh();

        SpringBeanOne springBean01 = anc.getBean(SpringBeanOne.class);
        SpringBeanTwo springBean02 = anc.getBean(SpringBeanTwo.class);
        System.out.println(springBean01);
        System.out.println(springBean02);

        SpringBeanThree springBean03 = anc.getBean(SpringBeanThree.class);
        System.out.println(springBean03);
    }


}
