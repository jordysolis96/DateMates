package com.datingapp.datemates.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateController {

    @GetMapping("/")
    public String homeView() {
        return "home";
    }

    @GetMapping("/create")
    public String createView() {
        return "create";
    }

    @GetMapping("/explore")
    public String exploreView() {
        return "explore";
    }

    @GetMapping("/profile")
    public String profileView() {
        return "profile";
    }
}