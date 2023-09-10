package lk.ijse.gdse.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kamal implements Di {
   // @Autowired // property injection
    SuperKamali kamali;

    //constructor throught
//    @Autowired
//    public Kamal(SuperKamali kamali) {
//        this.kamali = kamali;
//        System.out.println("kamal is initiated");
//    }

    // setter method
//    @Autowired
//    public void setkaamali (SuperKamali kamali){
//        this.kamali = kamali;
//    }

    public void chatWithKamali(){

       kamali.chat();
    }

    // Interface through injection
    @Autowired
    @Override
    public void inject(Kamali kamali) {
        this.kamali = kamali;
    }
}
