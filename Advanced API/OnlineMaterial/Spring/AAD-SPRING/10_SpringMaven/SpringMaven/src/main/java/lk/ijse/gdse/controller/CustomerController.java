package lk.ijse.gdse.controller;

import lk.ijse.gdse.lk.ijse.gdse.CustomerDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    public CustomerController() {
        System.out.println("this is the customer controller");
    }

//    @GetMapping(produces = "application/json")
    public CustomerDTO getAllCustomer(){
        return new CustomerDTO("Dilshan","Homagama");
    }

//    @GetMapping(consumes = "application/json")
    public CustomerDTO searchCustomer(){
        return new CustomerDTO("Dilshan","Homagama");
    }
    @GetMapping(consumes = "application/json",produces = "application/json")
    public CustomerDTO searchCus(){
        return new CustomerDTO("Dilshan","Homagama");
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "test01",consumes = "application/json",produces = "application/json", headers = {"Content-Type=application/json","Accept=application/json"})
    public CustomerDTO searchtest01(){
        return new CustomerDTO("Dilshan","Homagama");
    }
}
