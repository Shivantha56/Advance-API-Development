package lk.ijse.gdse.controll;



import lk.ijse.gdse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("json")
public class JsonController {

    @PostMapping
    public String test01(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO.toString());
        return "test 01";
    }


    @GetMapping(produces = "application/json") //MediaType
    public CustomerDTO sendBackJson(CustomerDTO customerDTO){

        return new CustomerDTO("123","dilshan","12","25.00");
    }
    @GetMapping(path = "array",produces = "application/json") //MediaType
    public CustomerDTO[] sendBackJsonArray(CustomerDTO customerDTO){

        CustomerDTO customerDTO01 = new CustomerDTO("123", "dilshan", "12", "25.00");
        CustomerDTO[] customer;
        return customer = new CustomerDTO[]{customerDTO01};
    }
}
