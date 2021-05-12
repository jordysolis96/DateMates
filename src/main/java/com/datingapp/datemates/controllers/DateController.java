package com.datingapp.datemates.controllers;

import com.datingapp.datemates.model.User;
import com.datingapp.datemates.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class DateController {

    private final UserRepository userDao;
    private final PasswordEncoder passwordEncoder;

    public DateController(UserRepository userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/")
    public String homeView(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @GetMapping("/sign-up")
    public String showsSignUpForm(Model model){
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/sign-up")
    public String saveUser(@ModelAttribute User user, Errors e, Model model) {
        if (e.hasErrors()) {
            model.addAttribute("errors", e);
            return "sign-up";
        } else if (userDao.findByUsername(user.getUsername()) != null) {
            model.addAttribute("username", user.getUsername());
            return "sign-up";
        } else if (userDao.findByEmail(user.getEmail()) != null) {
            model.addAttribute("email", user.getEmail());
            return "sign-up";
        }

        String password = user.getPassword();
        String hash = passwordEncoder.encode(password);
        user.setPassword(hash);
        String formattedUsername = user.getUsername().substring(0, 1).toUpperCase() + user.getUsername().substring(1);
        user.setUsername(formattedUsername);
        userDao.save(user);
        return "redirect:/";
    }

        @GetMapping("/create")
        public String createView () {
            return "create";
        }

        @GetMapping("/explore")
        public String exploreView () {
            return "explore";
        }

        @GetMapping("/profile")
        public String profileView () {
            return "profile";
        }
    }
