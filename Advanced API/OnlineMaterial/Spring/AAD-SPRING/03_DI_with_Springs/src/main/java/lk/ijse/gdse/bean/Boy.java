package lk.ijse.gdse.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Boy {

    @Qualifier("girlOne")
    @Autowired
    GoodGirl g;


    public Boy() {
        System.out.println("Boy is initiated");
    }

    public void getChatting(){
        g.chat();
    }
}
