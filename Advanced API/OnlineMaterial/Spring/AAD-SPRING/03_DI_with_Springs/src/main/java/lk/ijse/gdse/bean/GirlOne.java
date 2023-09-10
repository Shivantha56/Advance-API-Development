package lk.ijse.gdse.bean;

import org.springframework.stereotype.Component;

@Component
public class GirlOne implements GoodGirl {

    public GirlOne() {
        System.out.println("girlone is initiated");
    }

    @Override
    public void chat(){
        System.out.println("GirlOne Chatting");
    }
}
