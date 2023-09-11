package lk.ijse.gdse.bean;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bean02 implements InitializingBean {

    @Value("dilshan")
    String a;
    @Value("1")
    int b;
    @Value("true")
    boolean c;

    public Bean02() {
        System.out.println("Spring bean 02 initiates");
        System.out.println(a);//null
        System.out.println(b);//0
        System.out.println(c);//false
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("=========================");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }
}
