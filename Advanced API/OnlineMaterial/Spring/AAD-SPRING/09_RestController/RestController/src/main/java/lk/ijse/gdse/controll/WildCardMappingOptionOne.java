package lk.ijse.gdse.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("one")
public class WildCardMappingOptionOne {

    @GetMapping(path = "item/*/*")
    public String test02(){
        return "wil card mapping test02";
    }

    @GetMapping(path = "item/*/item")
    public String test(){
        return "wil card mapping one";
    }




}
