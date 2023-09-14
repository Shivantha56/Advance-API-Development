package lk.ijse.gdse.controll;

import lk.ijse.gdse.dto.CustomerDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("formData")
public class FormDataController {

//    @PostMapping
    public String test01(String id, String name, String age, String salary){

        System.out.println(id+" "+name+" "+age+" "+salary);
        return "Test 01";
    }
// @PostMapping
    public String test02(@ModelAttribute CustomerDTO dto){ //necessary to use model attribute

     System.out.println(dto.toString());
        return "Test 02";
    }

    @PostMapping(params = {"id","name","age","salary"})
    public String test03(@ModelAttribute CustomerDTO dto){
        System.out.println(dto.toString());
        return "test 03";
    }

}
