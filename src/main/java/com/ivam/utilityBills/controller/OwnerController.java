package com.ivam.utilityBills.controller;


import com.ivam.utilityBills.model.Owners;
import com.ivam.utilityBills.repository.OwnersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OwnerController {
    @Autowired
    OwnersRepository ownersRepository;

//findAllByIsCommonUserTrueOrderByIsActiveTrueName
    @GetMapping("/ownerslist")
    public String findAll(Model model) {
        List<Owners> owners = ownersRepository.findAllOderByIsActiveUserTrueDesk();
        model.addAttribute("ownerslist", owners);
        return "owners/ownerslist";
    }

    @GetMapping("/delete-owners")
    public String delete(@RequestParam int id) {
        ownersRepository.deleteById(id);
        return "redirect:ownerslist";
    }

    @GetMapping("/add-owner")
    public String add() {
        return "owners/add-owner";
    }

    @PostMapping("/add-owner")
    public String add(@ModelAttribute Owners owner) {
        ownersRepository.save(owner);
        return "redirect:ownerslist";
    }

    @GetMapping("/update-owner")
    public String update(@RequestParam int id, Model model) {
        Owners owner = ownersRepository.findById(id).get();
        model.addAttribute("owner", owner);
        return "owners/update-owner";
    }

    @PostMapping("/update-owner")
    public String update(@ModelAttribute Owners owner) {
        ownersRepository.save(owner);
        return "redirect:ownerslist";
    }
}
