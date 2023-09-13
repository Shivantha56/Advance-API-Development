package lk.ijse.gdse.controll;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("item")
public class ExactMappingController {

    //exact mapping
    @PostMapping(path = "it/test01")
    public String test01(){
        return "Item save sucess";
    }
    @PostMapping(path = "item02")
    public String test02(){
        return "Item save sucess";
    }
    @PostMapping(path = "item03/it/Iooo1")
    public String test03(){
        return "Item save sucess";
    }
}
