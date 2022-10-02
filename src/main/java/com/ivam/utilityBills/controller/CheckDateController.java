package com.ivam.utilityBills.controller;

import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.MetersData;
import com.ivam.utilityBills.repository.CheckDateRepository;
import com.ivam.utilityBills.repository.MetersDataRepository;
import com.ivam.utilityBills.service.PreBillCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CheckDateController {

    @Autowired
    PreBillCreator preBillCreator;

    @Autowired
    CheckDateRepository checkDateRepository;


    @GetMapping("/checkdate")
    public String findAllByOrderByIdDesc(Model model) {
        List<CheckDate> checkDates = checkDateRepository.findAllByOrderByIdDesc();
        model.addAttribute("checkdates", checkDates);
        return "checkdate/checkdate";
    }

    @GetMapping("/checkdateonlytwo")
    public String findTopTwo(Model model) {
        List<CheckDate> checkDates = preBillCreator.findTwoLastCheckDates();
        model.addAttribute("checkdates", checkDates);
        return "checkdate/checkdateonlytwo";
    }

    @GetMapping("/checkdatelast")
    public String getLastChekDate(Model model) {
        CheckDate checkDate = preBillCreator.getCurrentCheckDate();
        model.addAttribute("checkdates", checkDate);
        return "checkdate/checkdatelast";
    }



    @GetMapping("/delete-checkdate")
    public String delete(@RequestParam int id) {
        checkDateRepository.deleteById(id);
        return "redirect:checkdate";
    }

    @GetMapping("/add-checkdate")
    public String add() {
        return "checkdate/add-checkdate";
    }

    @PostMapping("/add-checkdate")
    public String add(@ModelAttribute CheckDate checkDate) {
        checkDateRepository.save(checkDate);
        return "redirect:checkdate";
    }

    @GetMapping("/update-checkdate")
    public String update(@RequestParam int id, Model model) {
        CheckDate checkDate = checkDateRepository.findById(id).get();
        model.addAttribute("checkdate", checkDate);
        return "checkdate/update-checkdate";
    }

    @PostMapping("/update-checkdate")
    public String update(@ModelAttribute CheckDate checkDate) {
        checkDateRepository.save(checkDate);
        return "redirect:checkdate";
    }
}


