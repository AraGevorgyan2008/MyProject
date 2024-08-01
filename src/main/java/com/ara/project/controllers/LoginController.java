package com.ara.project.controllers;

import com.ara.project.model.User;
import com.ara.project.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    public static String aaa = new String();

    @GetMapping("/login")
    public String home(Model model) {
        model.addAttribute("Login","Log in");
        return "login";
    }

    @PostMapping("/login")
    public String addUser(@RequestParam(name = "name") String name, @RequestParam(name = "emile") String emile, @RequestParam(name = "password") String password,@RequestParam(name = "role") String role, Model model) {
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        Iterator<User> iterator = userRepository.findAll().iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            String email = user.getEmail();
            String pass = user.getPassword();
            if (email.equals(emile) && encoder.matches(password, user.getPassword())  ){
                model.addAttribute("error_theris_acc","There is a host with such a gmail");
                return "login";
            }
        }

        aaa = name;
        userRepository.save(new User(name,emile,encoder.encode(password),role));
        if (role.equals("USER")){
            return "redirect:/user";
        }
        return "redirect:/verify_Admin";
    }
    @PostMapping("/verif")
    public String adminverif(@RequestParam(name = "code") String code, Model model) {
    if (code.equals("9999")){
        return "redirect:/admin";
    }else {
        return "redirect:/";
    }

    }
}
