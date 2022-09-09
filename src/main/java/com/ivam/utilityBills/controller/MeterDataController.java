package com.ivam.utilityBills.controller;

import com.ivam.utilityBills.model.CheckDate;
import com.ivam.utilityBills.model.Meter;
import com.ivam.utilityBills.model.MetersData;
import com.ivam.utilityBills.repository.CheckDateRepository;
import com.ivam.utilityBills.repository.MeterRepository;
import com.ivam.utilityBills.repository.MetersDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class MeterDataController {

    @Autowired
    MetersDataRepository metersDataRepository;

    @Autowired
    CheckDateRepository checkDateRepository;

    @Autowired
    MeterRepository meterRepository;


    @GetMapping("/metersdata")
    public String findAll(Model model) {
        List<MetersData> metersDataList = metersDataRepository.findAll();
        model.addAttribute("metersdatalist", metersDataList);
        return "metersdata/metersdata";
    }

    @GetMapping("/metersdata-for-checkdate")
    public String findAllByDate(@RequestParam int id, Model model) {
        Set<MetersData> metersDataList = metersDataRepository.getByCheckDates_IdOrderByMeter_IdAsc(id);
        model.addAttribute("metersdatalist", metersDataList);
        CheckDate checkDate = checkDateRepository.findById(id).get();
        model.addAttribute("checkdate", checkDate);
        return "metersdata/metersdatabydate";
    }

    @GetMapping("/delete-metersdata")
    public String delete(@RequestParam int id) {
        metersDataRepository.deleteById(id);
        return "redirect:checkdate";
    }

    @GetMapping("/add-metersdata")
    public String add(@RequestParam int id, Model model) {
        List<Meter> metersList = meterRepository.findAll();
        model.addAttribute("metersList", metersList);
        CheckDate checkDate = checkDateRepository.findById(id).get();
        model.addAttribute("checkdates", checkDate);
        return "metersdata/add-metersdata";
    }

    @PostMapping("/add-metersdata")
    public String add(@ModelAttribute MetersData metersData) {
        metersDataRepository.save(metersData);
        return "redirect:checkdate";
    }

    @GetMapping("/update-metersdata")
    public String update(@RequestParam int id, Model model) {
        MetersData meterData = metersDataRepository.findById(id).get();
        model.addAttribute("metersData", meterData);
        return "metersdata/update-metersdata";
    }

    @PostMapping("/update-metersdata")
    public String update(@ModelAttribute MetersData meterData) {
        metersDataRepository.save(meterData);
        return "redirect:checkdate";
    }
}
