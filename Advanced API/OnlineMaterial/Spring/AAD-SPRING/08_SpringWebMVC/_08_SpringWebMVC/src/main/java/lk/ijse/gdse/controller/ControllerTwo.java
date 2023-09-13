package lk.ijse.gdse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.annotation.WebServlet;

@Controller
@RequestMapping("two")
public class ControllerTwo {

    public ControllerTwo() {
        System.out.println("this is the controller two");
    }

    @GetMapping
    public String showView(){
        return "index";
    }
}
