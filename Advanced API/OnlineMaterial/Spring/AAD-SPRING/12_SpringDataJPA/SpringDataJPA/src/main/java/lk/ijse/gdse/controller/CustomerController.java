package lk.ijse.gdse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("customer")
@RestController
public class CustomerController {

    public CustomerController() {
        System.out.println("customer constructor created");
    }

    @GetMapping
    public String test01(){
        return "this is test 01 method in customer controller class";
    }
}
