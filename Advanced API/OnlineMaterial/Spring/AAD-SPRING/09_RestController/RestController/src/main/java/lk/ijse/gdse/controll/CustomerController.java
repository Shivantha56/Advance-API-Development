package lk.ijse.gdse.controll;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping//handler mapping
    public String getAllCustomer(){ //handler method
        return "get customer success";
    }
    @GetMapping(path = "search")//request narrow down
    public String searchCustomer(){
        return "search customer success";
    }

    @PostMapping
    public String saveCustomer(){
        return "customer save success";
    }

    @DeleteMapping
    public String deleteCustomer(){
        return "customer delete success";
    }

    @PutMapping
    public String updateCustomer(){
        return "customer update success";
    }
}

