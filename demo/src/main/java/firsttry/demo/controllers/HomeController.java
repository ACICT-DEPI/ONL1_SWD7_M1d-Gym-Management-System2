package firsttry.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")  // Maps to root URL
    public String home() {
        return "Welcome to the Home Page!";
    }
}
