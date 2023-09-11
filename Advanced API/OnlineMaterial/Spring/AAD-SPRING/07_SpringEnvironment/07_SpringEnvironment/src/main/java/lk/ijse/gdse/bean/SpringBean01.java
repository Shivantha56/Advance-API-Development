package lk.ijse.gdse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean01 implements InitializingBean {
    //property placeholder
    @Value("${user.name}")
    private String environmetn;

    @Value("${ijse.application.name}")
    private String projectName;

    public SpringBean01() {
        System.out.println("This is the spring bean one initiated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(environmetn);
        System.out.println(projectName);
    }
}
