package lk.ijse.gdse.di;

import org.springframework.stereotype.Component;

@Component
public class Kamali implements SuperKamali {

    public Kamali() {
        System.out.println("kamali is initated");
    }

    @Override
    public void chat(){
        System.out.println("kamal chatting with kamal");
    }

}
