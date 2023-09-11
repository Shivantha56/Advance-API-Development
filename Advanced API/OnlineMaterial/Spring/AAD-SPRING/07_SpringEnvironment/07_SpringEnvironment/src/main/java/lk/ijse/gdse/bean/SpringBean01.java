package lk.ijse.gdse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpringBean01 implements InitializingBean {
    @Value("${user.name}")
    private String environmetn;

    public SpringBean01() {
        System.out.println("This is the spring bean one initiated");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(environmetn);
    }
}
