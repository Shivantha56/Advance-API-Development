package lk.ijse.gdse.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("two")
public class WildCardMappingOptionTwo {

    @GetMapping(path = "item/**/abc")
    public String test02(){
        return "wil card mapping test02";
    }

//    @GetMapping(path = "item/*/item")
    public String test(){
        return "wil card mapping one";
    }




}
