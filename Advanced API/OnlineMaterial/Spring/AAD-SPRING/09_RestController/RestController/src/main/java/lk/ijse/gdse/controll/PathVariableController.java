package lk.ijse.gdse.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pathvariable")
public class PathVariableController {

//    @GetMapping(path = "{I001}")
    public String test01(@PathVariable("I001") String itemCode) {
        System.out.println(itemCode);
        return "path variable";
    }

//    @GetMapping(path = "{id}/{name}")

    //aliad dala kiyala thiyenne
    public String test02(@PathVariable("id") String itemCode ,@PathVariable("name") String name) {
        System.out.println(itemCode);
        System.out.println(name);
        return "path variable";
    }
//    @GetMapping(path = "{id}/{name}")
    public String test03(@PathVariable String id ,@PathVariable String name) { //alias dala kiyala nehe
        System.out.println(id);
        System.out.println(name);
        return "path variable 12";
    }
    //path variable with regular expressions
    @GetMapping(path = "{id:[a-z]{3}}/{name}")
    public String test04(@PathVariable String id ,@PathVariable String name) { //alias dala kiyala nehe
        System.out.println(id);
        System.out.println(name);
        return "path variable 12";
    }

}
