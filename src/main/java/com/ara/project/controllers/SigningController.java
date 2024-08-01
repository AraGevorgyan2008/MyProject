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
public class SigningController {
    @Autowired
    private UserRepository  userRepository;
    private static LoginController log;

    @GetMapping("/signing")
    public String home(Model model) {
        return "signing";
    }
    @PostMapping("/signing")
    public String sign(@RequestParam String email,@RequestParam String password, Model model) {
        log = new LoginController();
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        String hashedPassword = encoder.encode(password);
        Iterator<User> iterator = userRepository.findAll().iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            String email1 = next.getEmail();
            String pass = next.getPassword();
            LoginController.aaa = next.getName();
            if (email.equals(email1) && next.getRoles().equals("USER") && encoder.matches(password, pass)){
                return "redirect:/user";
            }if (email.equals(email1) && next.getRoles().equals("ADMIN") && encoder.matches(password, pass)){
                return "redirect:/admin";
            }
        }
        model.addAttribute("error_no_gm","Gmail is wrong");
        return "signing";
    }
}
