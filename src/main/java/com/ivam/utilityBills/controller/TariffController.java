package com.ivam.utilityBills.controller;



import com.ivam.utilityBills.ClassPreamble;
import com.ivam.utilityBills.model.Tariff;
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

@ClassPreamble(
        application = "Utility Billing Application",
        author = "@Author: Ivan Mochalov")
@Controller
public class TariffController {

    @Autowired
    TariffRepository tariffRepository;

    @GetMapping("/tariffs")
    public String findAll(Model model) {
        List<Tariff> tariff = tariffRepository.findAll();
        model.addAttribute("tariff", tariff);
        return "tariffs/tariffs";
    }


    @GetMapping("/delete-tariff")
    public String delete(@RequestParam int id) {
        tariffRepository.deleteById(id);
        return "redirect:tariffs";
    }

    @GetMapping("add-tariff")
    public String add() {
        return "tariffs/add-tariff";
    }

    @PostMapping("/add-tariff")
    public String add(@ModelAttribute Tariff tariff) {
        tariffRepository.save(tariff);
        return "redirect:tariffs";
    }

    @GetMapping("/update-tariff")
    public String update(@RequestParam int id, Model model) {
        Tariff tariff = tariffRepository.findById(id).get();
        model.addAttribute("tariff", tariff);
        return "tariffs/update-tariff";
    }

    @PostMapping("/update-tariff")
    public String update(@ModelAttribute Tariff tariff) {
        tariffRepository.save(tariff);
        return "redirect:tariffs";
    }
}
