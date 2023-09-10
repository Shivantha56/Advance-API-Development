package lk.ijse.gdse.bean;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary

@Component
public class GirlTwo implements GoodGirl {

    public GirlTwo() {
        System.out.println("girlTwo is initiated");
    }

    @Override
    public void chat(){
        System.out.println("GirlTwo Chatting");
    }
}
