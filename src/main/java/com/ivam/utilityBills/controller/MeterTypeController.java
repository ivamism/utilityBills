package com.ivam.utilityBills.controller;


import com.ivam.utilityBills.model.MeterType;
import com.ivam.utilityBills.repository.MeterRepository;
import com.ivam.utilityBills.repository.MeterTypeRepository;
import com.ivam.utilityBills.repository.TariffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MeterTypeController {

       @Autowired
    MeterTypeRepository meterTypeRepository;

    @Autowired
    TariffRepository tariffRepository;

    @GetMapping("/metertypes")
    public String findAll(Model model) {
        List<MeterType> types = meterTypeRepository.findAll();
        model.addAttribute("types", types);
        return "metertypes";
    }


    @GetMapping("/delete-metertype")
    public String delete(@RequestParam int id) {
        meterTypeRepository.deleteById(id);
        return "redirect:metertypes";
    }

    @GetMapping("/add-metertype")
    public String add(Model model) {
        model.addAttribute("tariff", tariffRepository.findAll());
        return "add-metertype";
    }

    @PostMapping("/add-metertype")
    public String add(@ModelAttribute MeterType meterType) {
        meterTypeRepository.save(meterType);
        return "redirect:metertypes";
    }

    @GetMapping("/update-metertype")
    public String update(@RequestParam int id, Model model) {
        MeterType type = meterTypeRepository.findById(id).get();
        model.addAttribute("tariff", tariffRepository.findAll());
        model.addAttribute("type", type);
        return "update-metertype";
    }


    @PostMapping("/update-metertype")
    public String update(@ModelAttribute MeterType type) {
        meterTypeRepository.save(type);
        return "redirect:metertypes";
    }
}
