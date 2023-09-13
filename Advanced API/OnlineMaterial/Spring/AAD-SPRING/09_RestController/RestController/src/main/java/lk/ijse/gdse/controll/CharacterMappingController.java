package lk.ijse.gdse.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("charactermapping")
public class CharacterMappingController {

    //character mapping
    // item/I3333
    // item/I5476
    // item/I456d
    // item/Idils


    @GetMapping(path = "item/I????")
    public String test01(){
        return "character mapping";
    }
    @GetMapping(path = "????/I????")
    public String test02(){
        return "character mapping";
    }

}
