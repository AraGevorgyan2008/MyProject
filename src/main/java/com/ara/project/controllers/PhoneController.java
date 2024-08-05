package com.ara.project.controllers;

import com.ara.project.model.Phone;
import com.ara.project.repo.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Controller
public class PhoneController {
    public List<Phone> all ;
    @Autowired
    private PhoneRepository phoneRepository;
@GetMapping("/addPhone")
    public String addPhone(Model model) {
    return "addphone";
}

    @GetMapping("/PhoneInfo")
    public String Phone(Model model) {
        model.addAttribute("info",all);
        return "phoneinfo";
    }


    @PostMapping("/addPhone")
    public String addPhone(@RequestParam String image,@RequestParam String phone_model,@RequestParam String new_price,@RequestParam String old_price,@RequestParam String phone_role, Model model) {
         phoneRepository.save(new Phone(image, phone_model, new_price, old_price, phone_role));

    return "redirect:/addPhone";
    }
    @PostMapping("/PhoneInfo")
    public String PhoneIn(@RequestParam(value = "id") String id, Model model) {
        System.out.println(id);
        Optional<Phone> iterator = phoneRepository.findById((long) Integer.parseInt(id));
        all = new ArrayList<>();
        iterator.ifPresent(all::add);


        return "redirect:/PhoneInfo";
    }
}
