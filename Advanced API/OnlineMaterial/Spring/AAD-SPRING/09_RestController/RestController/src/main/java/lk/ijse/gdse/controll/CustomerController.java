package lk.ijse.gdse.controll;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping//handler method
    public String getAllCustomer(){
        return "get customer success";
    }
    @GetMapping//handler method
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

