package lk.ijse.gdse.controll;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pathvariable")
public class PathVariableController {

    @GetMapping(path = "{I001}")
    public String test01(@PathVariable("I001") String itemCode) {
        System.out.println(itemCode);
        return "path variable";
    }

    @GetMapping(path = "{id}/{name}")
    public String test02(@PathVariable("id") String itemCode ,@PathVariable("name") String name) {
        System.out.println(itemCode);
        System.out.println(name);
        return "path variable";
    }

}
