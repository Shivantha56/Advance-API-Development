package lk.ijse.gdse.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Bean01 {

    @Autowired(required = false)
    public Bean01(@Value("C00-001") String id) {
        System.out.println("Spring bean 01");
        System.out.println(id);
    }
    //kaadaram kena thami run wenne
    @Autowired(required = false)
    public Bean01(@Value("C00-001") String id,@Value("A") char c) {
        System.out.println("Spring bean 01");
        System.out.println(c);
        System.out.println(id);
    }


}
