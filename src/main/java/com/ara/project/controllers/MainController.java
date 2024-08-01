package com.ara.project.controllers;

import com.ara.project.model.Phone;
import com.ara.project.repo.PhoneRepository;
import com.ara.project.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
@Autowired
private UserRepository userRepository;
    @Autowired
    private PhoneRepository phoneRepository;

    @GetMapping("/")
    public String home(Model model) {
        Iterable<Phone> all = phoneRepository.findAll();
        model.addAttribute("phones",all);
        return "index";
    }

    @GetMapping("/verify_Admin")
    public String adm_verify(Model model) {
        return "verificAdmin";
    }
}
