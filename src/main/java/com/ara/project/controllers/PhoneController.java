package com.ara.project.controllers;

import com.ara.project.model.Phone;
import com.ara.project.repo.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PhoneController {
    @Autowired
    private PhoneRepository phoneRepository;
@GetMapping("/addPhone")
    public String addPhone(Model model) {
    return "addphone";
}
    @PostMapping("/addPhone")
    public String addPhone(@RequestParam String image,@RequestParam String phone_model,@RequestParam String new_price,@RequestParam String old_price,@RequestParam String phone_role, Model model) {
         phoneRepository.save(new Phone(image, phone_model, new_price, old_price, phone_role));

    return "redirect:/addPhone";
    }
}
