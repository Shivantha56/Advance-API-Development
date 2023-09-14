package lk.ijse.gdse.controll;

import lk.ijse.gdse.dto.CustomerDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping(params = {"name", "salary"})
    public String test03(String name, @RequestParam("salary") double mySalary) {
        System.out.println(name + " " + mySalary);
        return "param test 03";
    }

    //    @GetMapping(path = ("one"),params = {"name","salary"})
    public String test04(String name, @RequestParam("salary") double mySalary) {
        System.out.println(name + " " + mySalary);
        return "param test 03";
    }

    //    @PostMapping(path = ("one"),params = {"param"})
    public String getArrayType(@RequestParam("param") CustomerDTO[] customerDTOS) {

        return "param test 03";
    }

    //    @PostMapping(path = ("one"),params = {"param"})
    public String getArrayTyped(@RequestParam("param") CustomerDTO[] customerDTOS) {

        return "param test 03";
    }

    @PostMapping(path = ("ones"))
    public String getMulValue(@RequestParam MultiValueMap<String,String> map) {

        String name = map.get("name").toString();
        String address = map.get("address").toString();
        System.out.println(name);
//        System.out.println(address);

        return "param test 03";
    }

}
