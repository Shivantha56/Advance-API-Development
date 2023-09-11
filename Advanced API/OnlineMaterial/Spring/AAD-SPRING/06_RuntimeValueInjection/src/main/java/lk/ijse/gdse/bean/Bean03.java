package lk.ijse.gdse.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bean03 {

    //System environment variable
    //java environment variable
    //our software environmental variable

    public Bean03() {
        System.out.println("bean03 initiated");
    }
}
