package com.ivam.utilityBills.controller;


import com.ivam.utilityBills.model.Meter;
import com.ivam.utilityBills.repository.FamilyRepository;
import com.ivam.utilityBills.repository.MeterRepository;
import com.ivam.utilityBills.repository.MeterTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MeterController {

    @Autowired
    MeterRepository meterRepository;
    @Autowired
    MeterTypeRepository meterTypeRepository;


    @GetMapping("/meters")
    public String findAll(Model model) {
        List<Meter> meters = meterRepository.findAll();
        model.addAttribute("meters", meters);
        return "meters";
    }

    @GetMapping("/delete-meter")
    public String delete(@RequestParam int id) {
        meterRepository.deleteById(id);
        return "redirect:meters";
    }

    @GetMapping("/add-meter")
    public String add() {
        return "add-meter";
    }

    @PostMapping("/add-meter")
    public String add(@ModelAttribute Meter meter) {
        meterRepository.save(meter);
        return "redirect:meters";
    }

    @GetMapping("/update-meter")
    public String update(@RequestParam int id, Model model) {
        Meter meter = meterRepository.findById(id).get();
        model.addAttribute("meter", meter);
        return "update-meter";
    }

    @PostMapping("/update-meter")
    public String update(@ModelAttribute Meter meter) {
        meterRepository.save(meter);
        return "redirect:meters";
    }
}
