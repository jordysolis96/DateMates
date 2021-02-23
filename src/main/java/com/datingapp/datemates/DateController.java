package com.datingapp.datemates;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateController {

    @GetMapping("/home")
    public String homeView() {
        return "home";
    }
}
