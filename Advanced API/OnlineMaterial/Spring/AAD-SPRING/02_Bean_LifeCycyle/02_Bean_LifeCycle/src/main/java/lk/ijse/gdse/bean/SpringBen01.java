package lk.ijse.gdse.bean;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)//Bean scope
public class SpringBen01 {

    public SpringBen01() {
        System.out.println("this is the springBean 01");
    }
}
