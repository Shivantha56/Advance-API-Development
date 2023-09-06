import bean.MyConnection;
import bean.SpringBeanOne;
import bean.SpringBeanThree;
import bean.SpringBeanTwo;
import bean.insidebean.MySubClass01;
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

//        SpringBeanOne springBean01 = anc.getBean(SpringBeanOne.class);
//        SpringBeanTwo springBean02 = anc.getBean(SpringBeanTwo.class);
//        System.out.println(springBean01);
//        System.out.println(springBean02);
//
//        SpringBeanThree springBean03 = anc.getBean(SpringBeanThree.class);
//        System.out.println(springBean03);
        Object springBean01 = anc.getBean("springBeanOne"); //get bean from bean id
        System.out.println(springBean01);
        Object springBean02 = anc.getBean("BeanTwo"); //Bean two is not a default id, it is custom generated id
        System.out.println(springBean02);
        MyConnection bean = anc.getBean(MyConnection.class);
        System.out.println("this is the my connection "+bean);

        MySubClass01 bean1 = anc.getBean(MySubClass01.class);
        MySubClass01 bean2 = anc.getBean(MySubClass01.class);
        MySubClass01 bean3 = anc.getBean(MySubClass01.class);

        System.out.println(bean1);
        System.out.println(bean2);
        System.out.println(bean3);


    }


}
