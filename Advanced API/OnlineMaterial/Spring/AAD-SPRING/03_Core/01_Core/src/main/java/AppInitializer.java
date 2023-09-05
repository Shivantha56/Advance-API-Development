import bean.SpringBean;
import config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext anc = new AnnotationConfigApplicationContext();
        anc.register(AppConfig.class);
        anc.refresh();

        SpringBean springBean = anc.getBean(SpringBean.class);
        springBean.getMyBean();

        System.out.println(springBean);
        anc.close();
    }


}
