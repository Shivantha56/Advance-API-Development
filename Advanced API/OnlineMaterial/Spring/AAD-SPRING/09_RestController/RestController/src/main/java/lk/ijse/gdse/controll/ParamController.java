package lk.ijse.gdse.controll;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("params")
public class ParamController {

    @GetMapping(params = {"param1", "param2"})
    public String test01(String param1, String param2) {

        System.out.println(param1 + " " + param2);
        return "param test 01";
    }

    @GetMapping
    public String test02() {
        return "param test 02";
    }

    @GetMapping(params = {"name","salary"})
    public String test03(String name, @RequestParam("salary") double mySalary) {
        System.out.println(name+" "+mySalary);
        return "param test 03";
    }

}
