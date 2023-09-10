package lk.ijse.gdse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kamal {
   // @Autowired // property injection
    SuperKamali kamali;

    @Autowired
    public Kamal(SuperKamali kamali) {
        this.kamali = kamali;
        System.out.println("kamal is initiated");
    }

    @Autowired
    public void setkaamali (SuperKamali kamali){
        this.kamali = kamali;
    }

    public void chatWithKamali(){

       kamali.chat();
    }
}
