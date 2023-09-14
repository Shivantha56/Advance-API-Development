package lk.ijse.gdse.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import lk.ijse.gdse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("customerApp")
@RestController
@CrossOrigin
public class CustomerController {

    public CustomerController() {
        System.out.println("constructor created");
    }

    @JsonCreator
    @GetMapping(produces = "application/json")
    public List<CustomerDTO> getAllCustomer(){

        ArrayList<CustomerDTO> customerList = new ArrayList<>();
        customerList.add(new CustomerDTO("C001","dilshan","homagama","1005.00"));
        customerList.add(new CustomerDTO("C002","dilshan","homagama","1005.00"));
        customerList.add(new CustomerDTO("C003","dilshan","homagama","1005.00"));
        customerList.add(new CustomerDTO("C004","dilshan","homagama","1005.00"));

        return customerList;
    }

    @PostMapping()
    public CustomerDTO saveCustomer (@RequestParam("customerId") String id, @RequestParam("customerName")  String name,  @RequestParam("customerAddress") String address , @RequestParam("customerSalary") String salary){
        System.out.println(id+" "+name+" "+address+" "+salary);
        return new CustomerDTO(id,name,address,salary);
    }

    @DeleteMapping
    public String delete(@RequestParam("customerId") String id){
        System.out.println(id);
        return "customer Deleted sucess";
    }

    @PutMapping
    public CustomerDTO updateCustomer(@ModelAttribute CustomerDTO customerDTO){
        System.out.println(customerDTO.toString());
        return customerDTO;
    }


}
