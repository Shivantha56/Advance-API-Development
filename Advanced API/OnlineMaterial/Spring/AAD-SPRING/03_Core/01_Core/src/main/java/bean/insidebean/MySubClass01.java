package bean.insidebean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class MySubClass01 {

    public MySubClass01() {
        System.out.println("this is my sub class 01");
    }
}
