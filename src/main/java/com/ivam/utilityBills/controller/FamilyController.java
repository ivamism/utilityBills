package com.ivam.utilityBills.controller;


import com.ivam.utilityBills.model.Family;
import com.ivam.utilityBills.repository.FamilyRepository;
import com.ivam.utilityBills.repository.MeterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FamilyController {
    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    MeterRepository meterRepository;


    @GetMapping("/familylist")
    public String findAll(Model model) {
        List<Family> families = familyRepository.findAll();
        model.addAttribute("familyList", families);
        return "familyList";
    }

    @GetMapping("/delete-family")
    public String delete(@RequestParam int id) {
        familyRepository.deleteById(id);
        return "redirect:familylist";
    }

    @GetMapping("/add-family")
    public String add() {
        return "add-family";
    }

    @PostMapping("/add-family")
    public String add(@ModelAttribute Family family) {
        familyRepository.save(family);
        return "redirect:familylist";
    }

    @GetMapping("/update-family")
    public String update(@RequestParam int id, Model model) {
        Family family = familyRepository.findById(id).get();
        model.addAttribute("family", family);
        return "update-family";
    }

    @PostMapping("/update-family")
    public String update(@ModelAttribute Family family) {
        familyRepository.save(family);
        return "redirect:familylist";
    }
}
