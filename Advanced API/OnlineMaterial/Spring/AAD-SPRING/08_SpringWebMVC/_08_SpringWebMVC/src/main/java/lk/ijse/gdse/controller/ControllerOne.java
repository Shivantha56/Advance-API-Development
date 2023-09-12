package lk.ijse.gdse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("controller")
public class ControllerOne {
    public ControllerOne() {
        System.out.println("controlller one init");
    }

    @GetMapping
    public String getName(){
        return "Dilshan";
    }

}
